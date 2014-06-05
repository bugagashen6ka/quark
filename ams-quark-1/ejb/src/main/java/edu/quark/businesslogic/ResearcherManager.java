package edu.quark.businesslogic;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;

import edu.quark.businessinterfaces.IResearcherManagement;
import edu.quark.dao.ResearcherDAO;
import edu.quark.datatypes.ResearcherDetails;
import edu.quark.datatypes.TimeInfo;
import edu.quark.model.Appointment;
import edu.quark.model.Group;
import edu.quark.model.Researcher;

@Stateless
@LocalBean
public class ResearcherManager implements IResearcherManagement {
	@EJB
	ResearcherDAO researcherDAO;
	public ResearcherManager() {
	}

	@Override
	public List<BigInteger> getResearcherIds(ResearcherDetails details) {
		List<BigInteger> retval = new ArrayList<BigInteger>(); 
		List<Researcher> rs = researcherDAO.findAll();
		for (Researcher r : rs) {
			if((details.getrId()==null || (details.getrId() == r.getRid())) &&
				(details.getTitle()==null || (details.getTitle() == r.getTitle())) &&
				(details.getEmailAddress()==null || (details.getEmailAddress() == r.getEmail())) &&
				(details.getFirstName()==null || (details.getFirstName() == r.getFirstName())) &&
				(details.getLastName()==null || (details.getLastName() == r.getLastName())) &&
				(details.getPhoneNbr()==null || (details.getPhoneNbr() == r.getPhoneNumber()))) {
				retval.add(r.getRid());
			}
		}
		return retval;
	}

	@Override
	public ResearcherDetails getResearcherDetails(BigInteger researcherId) {
		List<Researcher> rs = researcherDAO.findAll();
			for (Researcher r : rs) {
				if(r.getRid()==researcherId) {
					return new ResearcherDetails(r);
				}
			}
		return null;
	}

	@Override
	public List<ResearcherDetails> getResearcherDetails(
			List<BigInteger> researcherIds) {
		List<ResearcherDetails> retval = new ArrayList<ResearcherDetails>();
		for (BigInteger rid : researcherIds) {
			ResearcherDetails rd = this.getResearcherDetails(rid);
			if (rd != null) {
				retval.add(rd);
			}
		}
		return retval;
	}

	@Override
	public List<Appointment> getAppointments(BigInteger researcherId,
			TimeInfo time) {
		List<Appointment> retval = new ArrayList<Appointment>();
		try{
			Researcher r = researcherDAO.read(researcherId);
			Set<Appointment> as = r.getAppointments();
			for (Appointment a : as) {
				if(a.getStart().after(time.getStart()) &&
				   a.getEnd().before(time.getEnd())&&
				   a.getStart().before(a.getEnd())) {
					retval.add(a);
				}
			}
			return retval;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean checkEmail(String email) {
		List<Researcher> rs = researcherDAO.findAll();
		for (Researcher r : rs) {
			if(r.getEmail()==email) return false;
		}
		return true;
	}

	@Override
	public BigInteger createResearcher(String email, String password,
			String firstName, String lastName, String title, String phoneNumber) {
		if(!this.checkEmail(email)) return null;
		Researcher r = new Researcher();
		r.setAppointments(new HashSet<Appointment>());
		r.setCreatedAppointments(new HashSet<Appointment>());
		r.setCreatedGroups(new HashSet<Group>());
		r.setEmail(email);
		r.setFirstName(firstName);
		r.setLastName(lastName);
		r.setPassword(password);
		r.setPhoneNumber(phoneNumber);
		r.setTitle(title);
		BigInteger rid = researcherDAO.create(r);
		return rid;
	}

	@Override
	public Researcher checkCredentials(String email, String password) {
		List<Researcher> rs = researcherDAO.findAll();
		for (Researcher r : rs) {
			if(r.getEmail()==email && r.getPassword()==password)
				return r;
		}
		return null;
	}

}

package edu.quark.businesslogic;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import edu.quark.businessinterfaces.IResearcherManagement;
import edu.quark.dao.ResearcherDAO;
import edu.quark.datatypes.AppointmentDetails;
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
			if ((details.getrId() == null || (details.getrId().equals(r
					.getRid())))
					&& (details.getTitle() == null || (details.getTitle()
							.equals(r.getTitle())))
					&& (details.getEmailAddress() == null || (details
							.getEmailAddress().equals(r.getEmail())))
					&& (details.getFirstName() == null || (details
							.getFirstName().equals(r.getFirstName())))
					&& (details.getLastName() == null || (details.getLastName()
							.equals(r.getLastName())))
					&& (details.getPhoneNbr() == null || (details.getPhoneNbr()
							.equals(r.getPhoneNumber())))) {
				retval.add(r.getRid());
			}
		}
		return retval;
	}

	@Override
	public ResearcherDetails getResearcherDetails(BigInteger researcherId) {
		List<Researcher> rs = researcherDAO.findAll();
		for (Researcher r : rs) {
			if (r.getRid() == researcherId) {
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
	public List<AppointmentDetails> getAppointmentDetails(
			BigInteger researcherId, TimeInfo time) {
		List<AppointmentDetails> retval = new ArrayList<AppointmentDetails>();
		try {
			Researcher r = researcherDAO.read(researcherId);
			Set<Appointment> as = r.getAppointments();
			System.out.println("ATstart "+as.size());
			for (Appointment a : as) {
					retval.add(new AppointmentDetails(a));
			}
			System.out.println("Atexit "+retval.size());
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
			if (r.getEmail() == email)
				return false;
		}
		return true;
	}

	@Override
	public BigInteger createResearcher(String email, String password,
			String firstName, String lastName, String title, String phoneNumber) {
		if (!this.checkEmail(email))
			return null;
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
			if (r.getEmail().equals(email) && r.getPassword().equals(password))
				return r;
		}
		return null;
	}

}

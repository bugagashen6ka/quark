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

import edu.quark.businessinterfaces.IAppointmentManagement;
import edu.quark.dao.AppointmentDAO;
import edu.quark.dao.ResearcherDAO;
import edu.quark.datatypes.AppointmentDetails;
import edu.quark.datatypes.AppointmentType;
import edu.quark.datatypes.TimeInfo;
import edu.quark.model.Appointment;
import edu.quark.model.ConferenceAppointment;
import edu.quark.model.ProjectGroupMeeting;
import edu.quark.model.ResearchGroupMeeting;
import edu.quark.model.Researcher;
import edu.quark.model.TeachingAppointment;

@Stateless
@LocalBean
public class AppointmentManager implements IAppointmentManagement {
	@EJB
	AppointmentDAO appointmentDAO;
	@EJB
	ResearcherDAO researcherDAO;
	public AppointmentManager() {
	}

	@Override
	public List<BigInteger> getParticipantIds(BigInteger appointmentId) {
		List<Appointment> as = appointmentDAO.findAll();
		List<BigInteger> retval = new ArrayList<BigInteger>();
		for (Appointment a : as) {
			if (a.getAid()==appointmentId){
				for (Researcher r : a.getParticipants()) {
					retval.add(r.getRid());
				}
			}
		}
		return retval;
	}

	@Override
	public AppointmentDetails getAppointmentDetails(BigInteger appointmentId) {
		Appointment a = appointmentDAO.read(appointmentId);
		if(a != null) return new AppointmentDetails(a);
		return null;
	}

	@Override
	public List<AppointmentDetails> getAppointmentDetails(
			List<BigInteger> appointmentIds) {
		List<AppointmentDetails> retval = new ArrayList<AppointmentDetails>();
		for (BigInteger aid : appointmentIds) {
			AppointmentDetails ad = this.getAppointmentDetails(aid);
			if(ad!=null) retval.add(ad);
		}
		return retval;
	}

	@Override
	public boolean inviteResearcher(BigInteger researcherId,
			BigInteger appointmentId) {
		Appointment a = appointmentDAO.read(appointmentId);
		Researcher r = researcherDAO.read(researcherId);
		if(r!=null && a!=null) {
			a.getParticipants().add(r);
			r.getAppointments().add(a);
			researcherDAO.update(r);
			appointmentDAO.update(a);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAppointment(BigInteger researcherId,
			BigInteger appointmentId) {
		Appointment a = appointmentDAO.read(appointmentId);
		Researcher r = researcherDAO.read(researcherId);
		if(r!=null && a!=null) {
			a.getParticipants().remove(r);
			r.getAppointments().remove(a);
			if(a.getCreator().getRid()==researcherId) {
				appointmentDAO.delete(a);
			}
			researcherDAO.update(r);
			appointmentDAO.update(a);
			return true;
		}
		return false;
	}

	@Override
	public BigInteger createAppointment(BigInteger researcherId,
			AppointmentType type, BigInteger groupId, String location,
			String description, TimeInfo time) {
		try {
			Appointment a = null;
			if (type==AppointmentType.CONFERENCE_APPOINTMENT) {
				a= new ConferenceAppointment();
			} else if(type==AppointmentType.GENERIC_APPOINTMENT) {
				a= new Appointment();
			} else if(type==AppointmentType.PROJECT_GROUP_MEETING) {
				a= new ProjectGroupMeeting();
			} else if(type==AppointmentType.RESEARCH_GROUP_MEETING) {
				a= new ResearchGroupMeeting();
			} else if(type==AppointmentType.TEACHING_APPOINTMENT) {
				a= new TeachingAppointment();
			}
			Researcher r = researcherDAO.read(researcherId);
			a.setCreator(r);
			a.setDescription(description);
			a.setLocation(location);
			a.setStart(time.getStart());
			a.setEnd(time.getEnd());
			Set<Researcher> ps = new HashSet<Researcher>();
			ps.add(r);
			a.setParticipants(ps);
			BigInteger aid = appointmentDAO.create(a);
			return aid;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}

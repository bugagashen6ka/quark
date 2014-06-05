package edu.quark.systemlogic;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import edu.quark.businesslogic.AppointmentManager;
import edu.quark.businesslogic.ResearcherManager;
import edu.quark.datatypes.TimeInfo;
import edu.quark.model.Appointment;
import edu.quark.systeminterfaces.IConflicts;

@Stateless
@LocalBean
public class Conflicts implements IConflicts {

	@EJB
	private ResearcherManager researcherManager;

	@EJB
	private AppointmentManager appointmentManager;

	@Override
	public List<Appointment> getAppointmentsWithConflicts(
			BigInteger researcherId, TimeInfo time) {
		return researcherManager.getAppointments(researcherId, time);
	}

	@Override
	public List<BigInteger> getResearchersWithConflicts(
			BigInteger appointmentId, TimeInfo time) {
		List<BigInteger> participants = appointmentManager
				.getParticipantIds(appointmentId);
		List<BigInteger> conflicts = new ArrayList<BigInteger>();

		for (BigInteger p : participants) {
			if (researcherManager.getAppointments(p, time).size() > 1) {
				conflicts.add(p);
			}
		}

		return conflicts;
	}

}

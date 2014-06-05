package edu.quark.systeminterfaces;

import java.math.BigInteger;
import java.util.List;

import edu.quark.datatypes.TimeInfo;
import edu.quark.model.Appointment;

public interface IConflicts {
	/** @return appointment id's */
	List<Appointment> getAppointmentsWithConflicts(BigInteger researcherId,
			TimeInfo time);

	/** @return researcher id's */
	List<BigInteger> getResearchersWithConflicts(BigInteger appointmentId,
			TimeInfo time);
}

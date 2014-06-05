package edu.quark.systeminterfaces;

import java.math.BigInteger;
import java.util.List;

import edu.quark.datatypes.AppointmentDetails;
import edu.quark.datatypes.TimeInfo;

public interface IConflicts {
	/** @return appointment id's */
	List<AppointmentDetails> getAppointmentsWithConflicts(BigInteger researcherId,
			TimeInfo time);

	/** @return researcher id's */
	List<BigInteger> getResearchersWithConflicts(BigInteger appointmentId,
			TimeInfo time);
}

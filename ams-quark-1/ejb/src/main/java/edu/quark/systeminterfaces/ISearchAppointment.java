package edu.quark.systeminterfaces;

import java.math.BigInteger;
import java.util.List;

import edu.quark.datatypes.TimeInfo;

public interface ISearchAppointment {
	/** @return Appointment id's */
	List<BigInteger> getAppointmentIds(BigInteger researcherId, TimeInfo time);
}

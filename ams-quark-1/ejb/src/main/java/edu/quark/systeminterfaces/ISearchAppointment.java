package edu.quark.systeminterfaces;

import java.math.BigInteger;
import java.util.List;

import edu.quark.datatypes.AppointmentDetails;
import edu.quark.datatypes.TimeInfo;

public interface ISearchAppointment {
	List<AppointmentDetails> getAppointmentDetails(BigInteger researcherId, TimeInfo time);
}

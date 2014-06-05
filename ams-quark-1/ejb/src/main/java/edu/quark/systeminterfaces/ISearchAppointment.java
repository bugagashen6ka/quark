package edu.quark.systeminterfaces;

import java.math.BigInteger;
import java.util.List;

import edu.quark.datatypes.TimeInfo;
import edu.quark.model.Appointment;

public interface ISearchAppointment {
	List<Appointment> getAppointments(BigInteger researcherId, TimeInfo time);
}

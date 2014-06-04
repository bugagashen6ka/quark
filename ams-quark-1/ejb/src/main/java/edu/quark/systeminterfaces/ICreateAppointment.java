package edu.quark.systeminterfaces;

import java.math.BigInteger;

import edu.quark.datatypes.AppointmentType;

public interface ICreateAppointment {
	BigInteger createAppointment(BigInteger creatorId, AppointmentType type,
			BigInteger groupId, String location, String description);
}

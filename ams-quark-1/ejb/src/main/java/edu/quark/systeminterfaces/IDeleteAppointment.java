package edu.quark.systeminterfaces;

import java.math.BigInteger;

public interface IDeleteAppointment {
	boolean deleteAppointment(BigInteger appointmentId, BigInteger researcherId);
}

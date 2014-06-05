package edu.quark.businessinterfaces;

import java.math.BigInteger;
import java.util.List;

import edu.quark.datatypes.AppointmentDetails;
import edu.quark.datatypes.AppointmentType;
import edu.quark.datatypes.TimeInfo;

public interface IAppointmentManagement {
	/** @return researcher id's */
	List<BigInteger>  getParticipantIds(BigInteger appointmentId);

	AppointmentDetails getAppointmentDetails(BigInteger appointmentId);

	List<AppointmentDetails> getAppointmentDetails(
			List<BigInteger> appointmentIds);

	boolean inviteResearcher(BigInteger researcherId, BigInteger appointmentId);

	boolean deleteAppointment(BigInteger researcherId, BigInteger appointmentId);

	BigInteger createAppointment(BigInteger researcherId, AppointmentType type,
			BigInteger groupId, String location, String description, TimeInfo time);
}

package edu.quark.systemlogic;

import java.math.BigInteger;
import java.util.List;

import edu.quark.businessinterfaces.IAppointmentManagement;
import edu.quark.datatypes.AppointmentDetails;
import edu.quark.datatypes.AppointmentType;

public class DeleteAppointment implements IAppointmentManagement {

	@Override
	public BigInteger getParticipantIds(BigInteger appointmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppointmentDetails getAppointmentDetails(BigInteger appointmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppointmentDetails> getAppointmentDetails(
			List<BigInteger> appointmentIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean inviteResearcher(BigInteger researcherId,
			BigInteger appointmentId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAppointment(BigInteger researcherId,
			BigInteger appointmentId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BigInteger createAppointment(BigInteger researcherId,
			AppointmentType type, BigInteger groupId, String location,
			String description) {
		// TODO Auto-generated method stub
		return null;
	}

}

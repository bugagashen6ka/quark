package edu.quark.systemlogic;

import java.math.BigInteger;

import javax.ejb.Local;
import javax.enterprise.context.ApplicationScoped;

import edu.quark.datatypes.AppointmentType;
import edu.quark.systeminterfaces.ICreateAppointment;

@Local
@ApplicationScoped
public class CreateAppointment implements ICreateAppointment {

	@Override
	public BigInteger createAppointment(BigInteger creatorId,
			AppointmentType type, BigInteger groupId, String location,
			String description) {
		// TODO Auto-generated method stub
		return null;
	}

}

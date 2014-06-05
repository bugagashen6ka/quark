package edu.quark.systemlogic;

import java.math.BigInteger;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import edu.quark.businesslogic.AppointmentManager;
import edu.quark.datatypes.AppointmentType;
import edu.quark.datatypes.TimeInfo;
import edu.quark.systeminterfaces.ICreateAppointment;

@Stateless
@LocalBean
public class CreateAppointment implements ICreateAppointment {

	@EJB
	private AppointmentManager appointmentManager;

	@Override
	public BigInteger createAppointment(BigInteger creatorId,
			AppointmentType type, BigInteger groupId, String location,
			String description, TimeInfo timeInfo) {
		return appointmentManager.createAppointment(creatorId, type, groupId,
				location, description, timeInfo);
	}

}

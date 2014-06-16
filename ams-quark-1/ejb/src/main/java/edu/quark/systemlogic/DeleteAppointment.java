package edu.quark.systemlogic;

import java.math.BigInteger;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import edu.quark.systeminterfaces.IDeleteAppointment;
import edu.quark.businesslogic.AppointmentManager;

@Stateless
@LocalBean
public class DeleteAppointment implements IDeleteAppointment {

	@EJB
	private AppointmentManager appointmentManager;

	@Override
	public boolean deleteAppointment(BigInteger researcherId,
			BigInteger appointmentId) {
		return appointmentManager.deleteAppointment(researcherId, appointmentId);
	}

}

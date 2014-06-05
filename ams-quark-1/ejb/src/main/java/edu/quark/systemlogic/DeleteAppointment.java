package edu.quark.systemlogic;

import java.math.BigInteger;

import javax.ejb.Local;
import javax.enterprise.context.ApplicationScoped;

import edu.quark.systeminterfaces.IDeleteAppointment;

@Local
@ApplicationScoped
public class DeleteAppointment implements IDeleteAppointment {

	@Override
	public boolean deleteAppointment(BigInteger appointmentId,
			BigInteger researcherId) {
		// TODO Auto-generated method stub
		return false;
	}

	
}

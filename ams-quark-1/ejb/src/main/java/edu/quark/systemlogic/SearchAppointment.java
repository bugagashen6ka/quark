package edu.quark.systemlogic;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Local;
import javax.enterprise.context.ApplicationScoped;

import edu.quark.datatypes.TimeInfo;
import edu.quark.model.Appointment;
import edu.quark.systeminterfaces.ISearchAppointment;

@Local
@ApplicationScoped
public class SearchAppointment implements ISearchAppointment {

	@Override
	public List<BigInteger> getAppointmentIds(BigInteger researcherId,
			TimeInfo time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Appointment> getAppointments(BigInteger researcherId,
			TimeInfo time) {
		// TODO Auto-generated method stub
		return null;
	}

}

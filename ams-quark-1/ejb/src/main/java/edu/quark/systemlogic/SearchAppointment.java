package edu.quark.systemlogic;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;

import edu.quark.datatypes.TimeInfo;
import edu.quark.model.Appointment;
import edu.quark.systeminterfaces.ISearchAppointment;

@Stateless
@LocalBean
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

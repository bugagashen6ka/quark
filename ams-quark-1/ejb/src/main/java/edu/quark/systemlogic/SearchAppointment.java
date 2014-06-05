package edu.quark.systemlogic;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import edu.quark.businesslogic.ResearcherManager;
import edu.quark.datatypes.AppointmentDetails;
import edu.quark.datatypes.TimeInfo;
import edu.quark.systeminterfaces.ISearchAppointment;

@Stateless
@LocalBean
public class SearchAppointment implements ISearchAppointment {

	@EJB
	private ResearcherManager researcherManager;

	@Override
	public List<AppointmentDetails> getAppointmentDetails(BigInteger researcherId,
			TimeInfo time) {
		return researcherManager.getAppointmentDetails(researcherId, time);
	}

}

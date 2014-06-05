package edu.quark.systemlogic;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import edu.quark.businesslogic.AppointmentManager;
import edu.quark.systeminterfaces.ISearchParticipant;

@Stateless
@LocalBean
public class SearchParticipant implements ISearchParticipant {

	@EJB
	private AppointmentManager appointmentManager;

	@Override
	public List<BigInteger> getParticipantIds(BigInteger appointmentId) {
		return appointmentManager.getParticipantIds(appointmentId);
	}

}

package edu.quark.systemlogic;

import java.math.BigInteger;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import edu.quark.businesslogic.AppointmentManager;
import edu.quark.systeminterfaces.IInvite;

@Stateless
@LocalBean
public class Invite implements IInvite {

	@EJB
	private AppointmentManager appointmentManager;

	@Override
	public boolean invite(BigInteger researcherId, BigInteger appointmentId) {
		return appointmentManager.inviteResearcher(researcherId, appointmentId);
	}

}

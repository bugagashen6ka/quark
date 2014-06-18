package edu.quark.webservices;

import java.math.BigInteger;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import edu.quark.systeminterfaces.IInvite;

@Path("/Invite")
public class Invite implements IInvite {

	@EJB
	private edu.quark.systemlogic.Invite invite;

	@Path("/invite.json")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public boolean invite(@QueryParam("rid") BigInteger researcherId,
			@QueryParam("aid") BigInteger appointmentId) {
		return invite.invite(researcherId, appointmentId);
	}
}

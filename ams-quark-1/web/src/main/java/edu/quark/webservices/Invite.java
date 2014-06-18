package edu.quark.webservices;

import java.math.BigInteger;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.quark.model.Researcher;

@Path("/Invite")
public class Invite {

	@EJB
	private edu.quark.systemlogic.Invite invite;

	@EJB
	private edu.quark.webservices.User user;

	@Path("/invite.json")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response invite(@Context HttpHeaders httpHeaders,
			@QueryParam("rid") BigInteger researcherId,
			@QueryParam("aid") BigInteger appointmentId) {
		Researcher res = user.checkCredentials(httpHeaders);
		if (res == null)
			return Response.status(Status.UNAUTHORIZED).build();
		return Response.ok(invite.invite(researcherId, appointmentId)).build();
	}
}

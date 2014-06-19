package edu.quark.webservices;

import java.math.BigInteger;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.quark.model.Researcher;

@Path("/SearchParticipant")
public class SearchParticipant {

	@EJB
	private edu.quark.systemlogic.SearchParticipant searchParticipant;

	@EJB
	private edu.quark.webservices.User user;

	@GET
	@Path("/getParticipantIds.json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getParticipantIds(@Context HttpHeaders httpHeaders,
			@QueryParam("aid") BigInteger appointmentId) {
		Researcher res = user.checkCredentials(httpHeaders);
		if (res == null)
			return Response.status(Status.UNAUTHORIZED).build();
		return Response.ok(searchParticipant.getParticipantIds(appointmentId))
				.build();
	}

}

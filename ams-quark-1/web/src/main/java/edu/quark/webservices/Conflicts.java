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

import edu.quark.datatypes.TimeInfo;
import edu.quark.model.Researcher;

@Path("/Conflicts")
@Produces(MediaType.APPLICATION_JSON)
public class Conflicts {

	@EJB
	private edu.quark.systemlogic.Conflicts conflicts;

	@EJB
	private edu.quark.webservices.User user;

	@POST
	@Path("/getAppointmentsWithConfilcts.jbos")
	public Response getAppointmentsWithConflicts(
			@Context HttpHeaders httpHeaders,
			@QueryParam("rid") BigInteger researcherId, TimeInfo time) {
		Researcher res = user.checkCredentials(httpHeaders);
		if (res == null)
			return Response.status(Status.UNAUTHORIZED).build();
		return Response.ok(
				conflicts.getAppointmentsWithConflicts(researcherId, time))
				.build();
	}

	@POST
	@Path("/getResearchersWithConflicts")
	public Response getResearchersWithConflicts(
			@Context HttpHeaders httpHeaders,
			@QueryParam("aid") BigInteger appointmentId, TimeInfo time) {
		Researcher res = user.checkCredentials(httpHeaders);
		if (res == null)
			return Response.status(Status.UNAUTHORIZED).build();
		return Response.ok(
				conflicts.getResearchersWithConflicts(appointmentId, time))
				.build();
	}

}

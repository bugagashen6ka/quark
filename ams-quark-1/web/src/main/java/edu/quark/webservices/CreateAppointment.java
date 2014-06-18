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

import edu.quark.datatypes.AppointmentType;
import edu.quark.datatypes.TimeInfo;
import edu.quark.model.Researcher;

@Path("/CreateAppointment")
public class CreateAppointment {

	@EJB
	private edu.quark.systemlogic.CreateAppointment createAppointment;

	@EJB
	private edu.quark.webservices.User user;

	@Path("/createAppointment.json")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createAppointment(@Context HttpHeaders httpHeaders,
			@QueryParam("rid") BigInteger creatorId,
			@QueryParam("type") AppointmentType type,
			@QueryParam("gid") BigInteger groupId,
			@QueryParam("location") String location,
			@QueryParam("desc") String description, TimeInfo timeInfo) {
		Researcher res = user.checkCredentials(httpHeaders);
		if (res == null)
			return Response.status(Status.UNAUTHORIZED).build();
		return Response.ok(
				createAppointment.createAppointment(creatorId, type, groupId,
						location, description, timeInfo)).build();
	}

}

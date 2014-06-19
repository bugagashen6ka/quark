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

@Path("/SearchAppointment")
public class SearchAppointment {

	@EJB
	private edu.quark.systemlogic.SearchAppointment searchAppointment;

	@EJB
	private edu.quark.webservices.User user;

	@POST
	@Path("/getAppointmentDetails.json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAppointmentDetails(@Context HttpHeaders httpHeaders,
			@QueryParam("rid") BigInteger researcherId, TimeInfo time) {
		Researcher res = user.checkCredentials(httpHeaders);
		if (res == null)
			return Response.status(Status.UNAUTHORIZED).build();
		return Response.ok(
				searchAppointment.getAppointmentDetails(researcherId, time))
				.build();
	}

}

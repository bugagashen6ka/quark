package edu.quark.webservices;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.quark.datatypes.ResearcherDetails;
import edu.quark.model.Researcher;

@Path("/Login")
public class Login {

	@EJB
	private edu.quark.webservices.User user;

	@GET
	@Path("/login.json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@Context HttpHeaders httpHeaders) {
		Researcher r = user.checkCredentials(httpHeaders);
		if (r != null)
			return Response.ok().entity(new ResearcherDetails(r)).build();
		else
			return Response.status(Status.UNAUTHORIZED).build();
	}

}

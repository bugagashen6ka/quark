package edu.quark.webservices;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.quark.model.Researcher;

@Path("/SearchGroup")
public class SearchGroup {

	@EJB
	private edu.quark.systemlogic.SearchGroup searchGroup;

	@EJB
	private edu.quark.webservices.User user;

	@Path("/getGroupDetails.json")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGroupDetails(@Context HttpHeaders httpHeaders,
			Researcher researcher) {
		Researcher res = user.checkCredentials(httpHeaders);
		if (res == null)
			return Response.status(Status.UNAUTHORIZED).build();
		return Response.ok(searchGroup.getGroupDetails(researcher)).build();
	}

}

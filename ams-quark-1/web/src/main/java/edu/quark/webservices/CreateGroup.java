package edu.quark.webservices;

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

import edu.quark.datatypes.GroupType;
import edu.quark.model.Researcher;

@Path("/CreateGroup")
public class CreateGroup {

	@EJB
	private edu.quark.systemlogic.CreateGroup createGroup;

	@EJB
	private edu.quark.webservices.User user;

	@Path("/createGroup.json")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createGroup(@Context HttpHeaders httpHeaders,
			Researcher researcher, @QueryParam("name") String name,
			@QueryParam("type") GroupType type,
			@QueryParam("password") String password) {
		Researcher res = user.checkCredentials(httpHeaders);
		if (res == null)
			return Response.status(Status.UNAUTHORIZED).build();
		return Response.ok(
				createGroup.createGroup(researcher, name, type, password))
				.build();
	}

}

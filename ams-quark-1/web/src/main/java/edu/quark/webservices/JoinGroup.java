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

@Path("/JoinGroup")
public class JoinGroup {

	@EJB
	private edu.quark.systemlogic.JoinGroup joinGroup;

	@EJB
	private edu.quark.webservices.User user;

	@POST
	@Path("/join.json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response join(@Context HttpHeaders httpHeaders,
			Researcher researcher, @QueryParam("gid") BigInteger groupId,
			@QueryParam("password") String password) {
		Researcher res = user.checkCredentials(httpHeaders);
		if (res == null)
			return Response.status(Status.UNAUTHORIZED).build();
		return Response.ok(joinGroup.join(researcher, groupId, password))
				.build();
	}

}

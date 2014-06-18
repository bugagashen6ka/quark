package edu.quark.webservices;

import java.math.BigInteger;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.quark.model.Researcher;

@Path("/LeaveGroup")
public class LeaveGroup {

	@EJB
	private edu.quark.systemlogic.LeaveGroup leaveGroup;

	@EJB
	private edu.quark.webservices.User user;

	@POST
	@Path("/leave.json")
	public Response leave(@Context HttpHeaders httpHeaders,
			@QueryParam("rid") BigInteger researcherId,
			@QueryParam("gid") BigInteger groupId) {
		Researcher res = user.checkCredentials(httpHeaders);
		if (res == null)
			return Response.status(Status.UNAUTHORIZED).build();
		leaveGroup.leave(researcherId, groupId);
		return Response.ok().build();
	}

}

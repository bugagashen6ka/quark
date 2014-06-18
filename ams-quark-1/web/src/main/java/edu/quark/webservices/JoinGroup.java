package edu.quark.webservices;

import java.math.BigInteger;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import edu.quark.model.Researcher;
import edu.quark.systeminterfaces.IJoinGroup;

@Path("/JoinGroup")
public class JoinGroup implements IJoinGroup {

	@EJB
	private edu.quark.systemlogic.JoinGroup joinGroup;

	@POST
	@Path("/join.json")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public boolean join(Researcher researcher,
			@QueryParam("gid") BigInteger groupId,
			@QueryParam("password") String password) {
		return joinGroup.join(researcher, groupId, password);
	}

}

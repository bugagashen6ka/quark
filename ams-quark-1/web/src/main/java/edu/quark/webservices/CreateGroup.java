package edu.quark.webservices;

import java.math.BigInteger;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import edu.quark.datatypes.GroupType;
import edu.quark.model.Researcher;
import edu.quark.systeminterfaces.ICreateGroup;

@Path("/CreateGroup")
public class CreateGroup implements ICreateGroup {

	@EJB
	private edu.quark.systemlogic.CreateGroup createGroup;

	@Path("/createGroup.json")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public BigInteger createGroup(Researcher researcher,
			@QueryParam("name") String name,
			@QueryParam("type") GroupType type,
			@QueryParam("password") String password) {
		return createGroup.createGroup(researcher, name, type, password);
	}

}

package edu.quark.webservices;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import edu.quark.datatypes.ResearcherDetails;

@Path("/ViewGroupMembers")
public class ViewGroupMembers {

	@EJB
	private edu.quark.systemlogic.ViewGroupMembers viewGroupMembers;

	@GET
	@Path("/viewMembers.json")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ResearcherDetails> ViewMembers(@QueryParam("gid") BigInteger gid) {
		return viewGroupMembers.ViewMembers(gid);
	}
}

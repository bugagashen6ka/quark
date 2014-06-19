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

import edu.quark.datatypes.ResearcherDetails;
import edu.quark.model.Researcher;

@Path("/SearchResearcher")
@Produces(MediaType.APPLICATION_JSON)
public class SearchResearcher {

	@EJB
	private edu.quark.systemlogic.SearchResearcher searchResearcher;

	@EJB
	private edu.quark.webservices.User user;

	@POST
	@Path("/getResearcherIds.json")
	public Response getResearcherIds(@Context HttpHeaders httpHeaders,
			ResearcherDetails details) {
		Researcher res = user.checkCredentials(httpHeaders); 
		if (res == null)
			return Response.status(Status.UNAUTHORIZED).build();
		return Response.ok(searchResearcher.getResearcherIds(details)).build();
	}
}

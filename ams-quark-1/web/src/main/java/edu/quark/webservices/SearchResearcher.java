package edu.quark.webservices;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.quark.datatypes.ResearcherDetails;
import edu.quark.systeminterfaces.ISearchResearcher;

@Path("/SearchResearcher")
@Produces(MediaType.APPLICATION_JSON)
public class SearchResearcher implements ISearchResearcher {

	@EJB
	private edu.quark.systemlogic.SearchResearcher searchResearcher;
	
	@POST
	@Path("/getResearcherIds.json")
	@Override
	public List<BigInteger> getResearcherIds(ResearcherDetails details) {
		return searchResearcher.getResearcherIds(details);
	}
}

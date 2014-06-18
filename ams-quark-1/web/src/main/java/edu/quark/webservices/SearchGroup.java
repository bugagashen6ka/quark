package edu.quark.webservices;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.quark.datatypes.GroupDetails;
import edu.quark.model.Researcher;
import edu.quark.systeminterfaces.ISearchGroup;

@Path("/SearchGroup")
public class SearchGroup implements ISearchGroup {

	@EJB
	private edu.quark.systemlogic.SearchGroup searchGroup;

	@Path("/getGroupDetails.json")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<GroupDetails> getGroupDetails(Researcher researcher) {
		return searchGroup.getGroupDetails(researcher);
	}

}

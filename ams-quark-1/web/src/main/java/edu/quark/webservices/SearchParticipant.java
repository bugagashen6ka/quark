package edu.quark.webservices;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import edu.quark.systeminterfaces.ISearchParticipant;

@Path("/SearchParticipant")
public class SearchParticipant implements ISearchParticipant {

	@EJB
	private edu.quark.systemlogic.SearchParticipant searchParticipant;

	@GET
	@Path("/getParticipantIds.json")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<BigInteger> getParticipantIds(
			@QueryParam("aid") BigInteger appointmentId) {
		return searchParticipant.getParticipantIds(appointmentId);
	}

}

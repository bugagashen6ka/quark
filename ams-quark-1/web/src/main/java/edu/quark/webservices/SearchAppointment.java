package edu.quark.webservices;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import edu.quark.datatypes.AppointmentDetails;
import edu.quark.datatypes.TimeInfo;
import edu.quark.systeminterfaces.ISearchAppointment;

@Path("/SearchAppointment")
public class SearchAppointment implements ISearchAppointment {

	@EJB
	private edu.quark.systemlogic.SearchAppointment searchAppointment;

	@POST
	@Path("/getAppointmentDetails.json")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<AppointmentDetails> getAppointmentDetails(
			@QueryParam("rid") BigInteger researcherId, TimeInfo time) {
		return searchAppointment.getAppointmentDetails(researcherId, time);
	}

}

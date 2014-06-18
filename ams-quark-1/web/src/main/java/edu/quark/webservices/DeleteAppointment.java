package edu.quark.webservices;

import java.math.BigInteger;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import edu.quark.systeminterfaces.IDeleteAppointment;

@Path("/DeleteAppointment")
public class DeleteAppointment implements IDeleteAppointment {

	@EJB
	private edu.quark.systemlogic.DeleteAppointment deleteAppointment;

	@Path("/deleteAppointment.json")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public boolean deleteAppointment(
			@QueryParam("rid") BigInteger researcherId,
			@QueryParam("aid") BigInteger appointmentId) {
		return deleteAppointment.deleteAppointment(researcherId, appointmentId);
	}

}

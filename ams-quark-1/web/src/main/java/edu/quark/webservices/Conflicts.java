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
import edu.quark.systeminterfaces.IConflicts;

@Path("/Conflicts")
@Produces(MediaType.APPLICATION_JSON)
public class Conflicts implements IConflicts {

	@EJB
	private edu.quark.systemlogic.Conflicts conflicts;

	@POST
	@Path("/getAppointmentsWithConfilcts.jbos")
	@Override
	public List<AppointmentDetails> getAppointmentsWithConflicts(
			@QueryParam("rid") BigInteger researcherId, TimeInfo time) {
		return conflicts.getAppointmentsWithConflicts(researcherId, time);
	}

	@POST
	@Path("/getResearchersWithConflicts")
	@Override
	public List<BigInteger> getResearchersWithConflicts(
			@QueryParam("aid") BigInteger appointmentId, TimeInfo time) {
		return conflicts.getResearchersWithConflicts(appointmentId, time);
	}

}

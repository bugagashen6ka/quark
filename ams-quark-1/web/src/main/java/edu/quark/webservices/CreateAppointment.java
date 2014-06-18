package edu.quark.webservices;

import java.math.BigInteger;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import edu.quark.datatypes.AppointmentType;
import edu.quark.datatypes.TimeInfo;
import edu.quark.systeminterfaces.ICreateAppointment;

@Path("/CreateAppointment")
public class CreateAppointment implements ICreateAppointment {

	@EJB
	private edu.quark.systemlogic.CreateAppointment createAppointment;

	@Path("/createAppointment.json")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public BigInteger createAppointment(
			@QueryParam("rid") BigInteger creatorId,
			@QueryParam("type") AppointmentType type,
			@QueryParam("gid") BigInteger groupId,
			@QueryParam("location") String location,
			@QueryParam("desc") String description, TimeInfo timeInfo) {
		return createAppointment.createAppointment(creatorId, type, groupId,
				location, description, timeInfo);
	}

}

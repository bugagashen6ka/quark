package edu.quark.webservices;

import java.util.Date;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import edu.quark.datatypes.TimeInfo;

@Path("/Time")
public class Time {

	@EJB
	private Time time;
	
	@GET
	@Path("/createTimeInformation.json")
	@Produces(MediaType.APPLICATION_JSON)
	public TimeInfo createTimeInformation(@QueryParam("start") Date start,
			@QueryParam("end") Date end) {
		return time.createTimeInformation(start, end);
	}
}

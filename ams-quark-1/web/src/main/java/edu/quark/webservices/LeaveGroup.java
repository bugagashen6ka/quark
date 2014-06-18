package edu.quark.webservices;

import java.math.BigInteger;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import edu.quark.systeminterfaces.ILeaveGroup;

@Path("/LeaveGroup")
public class LeaveGroup implements ILeaveGroup {

	@EJB
	private edu.quark.systemlogic.LeaveGroup leaveGroup;

	@POST
	@Path("/leave.json")
	@Override
	public void leave(@QueryParam("rid") BigInteger researcherId,
			@QueryParam("gid") BigInteger groupId) {
		leaveGroup.leave(researcherId, groupId);
	}

}

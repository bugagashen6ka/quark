package edu.quark.systemlogic;

import java.math.BigInteger;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import edu.quark.businesslogic.GroupManager;
import edu.quark.systeminterfaces.ILeaveGroup;

@Stateless
@LocalBean
public class LeaveGroup implements ILeaveGroup {

	@EJB
	private GroupManager groupManager;

	@Override
	public void leave(BigInteger researcherId, BigInteger groupId) {
		// Do nothing at the moment
		groupManager.leaveGroup(researcherId, groupId);
	}

}

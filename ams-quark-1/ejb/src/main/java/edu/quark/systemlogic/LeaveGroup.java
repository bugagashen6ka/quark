package edu.quark.systemlogic;

import java.math.BigInteger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import edu.quark.systeminterfaces.ILeaveGroup;

@Stateless
@LocalBean
public class LeaveGroup implements ILeaveGroup {

	@Override
	public boolean leave(BigInteger researcherId, BigInteger groupId) {
		// TODO Auto-generated method stub
		// Do nothing at the moment
		return false;
	}

}

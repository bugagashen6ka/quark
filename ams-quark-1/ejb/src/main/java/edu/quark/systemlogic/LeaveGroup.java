package edu.quark.systemlogic;

import java.math.BigInteger;

import javax.ejb.Local;
import javax.enterprise.context.ApplicationScoped;

import edu.quark.systeminterfaces.ILeaveGroup;

@Local
@ApplicationScoped
public class LeaveGroup implements ILeaveGroup {

	@Override
	public boolean leave(BigInteger researcherId, BigInteger groupId) {
		// TODO Auto-generated method stub
		return false;
	}

}

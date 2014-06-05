package edu.quark.systemlogic;

import java.math.BigInteger;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;

import edu.quark.systeminterfaces.ILeaveGroup;

@Stateless
@LocalBean
public class LeaveGroup implements ILeaveGroup {

	@Override
	public boolean leave(BigInteger researcherId, BigInteger groupId) {
		// TODO Auto-generated method stub
		return false;
	}

}

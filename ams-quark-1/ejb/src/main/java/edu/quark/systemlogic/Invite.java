package edu.quark.systemlogic;

import java.math.BigInteger;

import javax.ejb.Local;
import javax.enterprise.context.ApplicationScoped;

import edu.quark.systeminterfaces.IInvite;

@Local
@ApplicationScoped
public class Invite implements IInvite {

	@Override
	public boolean invite(BigInteger researcherId) {
		// TODO Auto-generated method stub
		return false;
	}

}

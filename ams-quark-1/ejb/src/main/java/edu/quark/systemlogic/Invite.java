package edu.quark.systemlogic;

import java.math.BigInteger;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;

import edu.quark.systeminterfaces.IInvite;

@Stateless
@LocalBean
public class Invite implements IInvite {

	@Override
	public boolean invite(BigInteger researcherId) {
		// TODO Auto-generated method stub
		return false;
	}

}

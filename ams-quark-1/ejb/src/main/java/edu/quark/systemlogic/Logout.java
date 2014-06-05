package edu.quark.systemlogic;

import java.math.BigInteger;

import javax.ejb.Local;
import javax.enterprise.context.ApplicationScoped;

import edu.quark.systeminterfaces.ILogout;

@Local
@ApplicationScoped
public class Logout implements ILogout {

	@Override
	public boolean logout(BigInteger researcherId) {
		// TODO Auto-generated method stub
		return false;
	}

}

package edu.quark.systemlogic;

import java.math.BigInteger;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;

import edu.quark.systeminterfaces.ILogout;

@Stateless
@LocalBean
public class Logout implements ILogout {

	@Override
	public boolean logout(BigInteger researcherId) {
		// TODO Auto-generated method stub
		return false;
	}

}

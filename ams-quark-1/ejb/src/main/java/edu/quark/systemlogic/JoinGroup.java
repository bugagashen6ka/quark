package edu.quark.systemlogic;

import java.math.BigInteger;

import javax.ejb.Local;
import javax.enterprise.context.ApplicationScoped;

import edu.quark.systeminterfaces.IJoinGroup;

@Local
@ApplicationScoped
public class JoinGroup implements IJoinGroup {

	@Override
	public boolean join(BigInteger researcherId, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}

package edu.quark.systemlogic;

import java.math.BigInteger;

import javax.ejb.Local;
import javax.enterprise.context.ApplicationScoped;

import edu.quark.systeminterfaces.ILogin;

@Local
@ApplicationScoped
public class Login implements ILogin {

	@Override
	public BigInteger login(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}

package edu.quark.systemlogic;

import java.math.BigInteger;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;

import edu.quark.systeminterfaces.ILogin;

@Stateless
@LocalBean
public class Login implements ILogin {

	@Override
	public BigInteger login(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}

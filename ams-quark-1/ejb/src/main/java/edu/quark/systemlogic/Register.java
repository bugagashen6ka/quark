package edu.quark.systemlogic;

import java.math.BigInteger;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;

import edu.quark.systeminterfaces.IRegister;

@Stateless
@LocalBean
public class Register implements IRegister {

	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BigInteger createResearcher(String email, String password,
			String firstName, String lastName, String title, String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}

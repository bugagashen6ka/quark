package edu.quark.systeminterfaces;

import java.math.BigInteger;

public interface IRegister {
	boolean checkEmail(String email);

	BigInteger createResearcher(String email, String password,
			String firstName, String lastName, String title, String phoneNumber);
}

package edu.quark.systeminterfaces;

import java.math.BigInteger;

public interface ILogin {
	/** @return researcher id */
	BigInteger login(String email, String password);
}

package edu.quark.systeminterfaces;

import edu.quark.model.Researcher;

public interface ILogin {
	/** @return researcher id */
	Researcher login(String email, String password);
}

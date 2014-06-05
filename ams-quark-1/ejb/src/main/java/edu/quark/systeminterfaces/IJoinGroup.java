package edu.quark.systeminterfaces;

import java.math.BigInteger;

import edu.quark.model.Researcher;

public interface IJoinGroup {
	boolean join(Researcher researcher, BigInteger groupId, String password);
}

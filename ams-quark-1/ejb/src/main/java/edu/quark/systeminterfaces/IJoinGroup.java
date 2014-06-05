package edu.quark.systeminterfaces;

import java.math.BigInteger;

public interface IJoinGroup {
	boolean join(BigInteger researcherId, BigInteger groupId, String password);
}

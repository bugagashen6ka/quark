package edu.quark.systeminterfaces;

import java.math.BigInteger;

import edu.quark.datatypes.GroupType;

public interface ICreateGroup {
	BigInteger createGroup(String name, GroupType type, String password);
}

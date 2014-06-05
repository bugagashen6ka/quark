package edu.quark.systeminterfaces;

import java.math.BigInteger;

import edu.quark.datatypes.GroupType;
import edu.quark.model.Researcher;

public interface ICreateGroup {
	BigInteger createGroup(Researcher researcher, String name, GroupType type, String password);
}

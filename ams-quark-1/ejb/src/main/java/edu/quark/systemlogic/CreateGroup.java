package edu.quark.systemlogic;

import java.math.BigInteger;

import javax.ejb.Local;
import javax.enterprise.context.ApplicationScoped;

import edu.quark.datatypes.GroupType;
import edu.quark.systeminterfaces.ICreateGroup;

@Local
@ApplicationScoped
public class CreateGroup implements ICreateGroup {

	@Override
	public BigInteger createGroup(String groupName, GroupType type) {
		// TODO Auto-generated method stub
		return null;
	}

}

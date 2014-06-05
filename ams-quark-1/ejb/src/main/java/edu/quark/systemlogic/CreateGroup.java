package edu.quark.systemlogic;

import java.math.BigInteger;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;

import edu.quark.datatypes.GroupType;
import edu.quark.systeminterfaces.ICreateGroup;

@Stateless
@LocalBean
public class CreateGroup implements ICreateGroup {

	@Override
	public BigInteger createGroup(String groupName, GroupType type) {
		// TODO Auto-generated method stub
		return null;
	}

}

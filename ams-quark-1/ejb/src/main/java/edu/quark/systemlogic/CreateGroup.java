package edu.quark.systemlogic;

import java.math.BigInteger;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import edu.quark.businesslogic.GroupManager;
import edu.quark.datatypes.GroupType;
import edu.quark.systeminterfaces.ICreateGroup;

@Stateless
@LocalBean
public class CreateGroup implements ICreateGroup {

	@EJB
	private GroupManager groupManager;

	@Override
	public BigInteger createGroup(String name, GroupType type, String password) {
		return groupManager.createGroup(null, name, type, password);
	}

}

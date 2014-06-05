package edu.quark.systemlogic;

import java.math.BigInteger;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import edu.quark.businesslogic.GroupManager;
import edu.quark.model.Researcher;
import edu.quark.systeminterfaces.IJoinGroup;

@Stateless
@LocalBean
public class JoinGroup implements IJoinGroup {

	@EJB
	private GroupManager groupManager;

	@Override
	public boolean join(Researcher researcher, BigInteger groupId,
			String password) {
		return groupManager.joinGroup(researcher, groupId, password);
	}

}

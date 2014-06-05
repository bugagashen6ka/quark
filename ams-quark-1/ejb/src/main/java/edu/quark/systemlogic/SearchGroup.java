package edu.quark.systemlogic;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import edu.quark.businesslogic.GroupManager;
import edu.quark.systeminterfaces.ISearchGroup;

@Stateless
@LocalBean
public class SearchGroup implements ISearchGroup {

	@EJB
	private GroupManager groupManager;

	@Override
	public List<BigInteger> getGroupIds(BigInteger researcherId) {
		return groupManager.getGroupIds(researcherId);
	}

}

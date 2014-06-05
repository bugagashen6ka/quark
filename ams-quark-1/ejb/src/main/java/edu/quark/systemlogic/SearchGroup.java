package edu.quark.systemlogic;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Local;
import javax.enterprise.context.ApplicationScoped;

import edu.quark.systeminterfaces.ISearchGroup;

@Local
@ApplicationScoped
public class SearchGroup implements ISearchGroup {

	@Override
	public List<BigInteger> getGroupIds(BigInteger researcherId) {
		// TODO Auto-generated method stub
		return null;
	}

}

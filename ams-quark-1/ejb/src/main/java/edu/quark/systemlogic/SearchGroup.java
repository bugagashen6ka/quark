package edu.quark.systemlogic;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;

import edu.quark.systeminterfaces.ISearchGroup;

@Stateless
@LocalBean
public class SearchGroup implements ISearchGroup {

	@Override
	public List<BigInteger> getGroupIds(BigInteger researcherId) {
		// TODO Auto-generated method stub
		return null;
	}

}

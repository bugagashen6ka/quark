package edu.quark.systeminterfaces;

import java.math.BigInteger;
import java.util.List;

public interface ISearchGroup {
	/**
	 * @return group id's */
	List<BigInteger> getGroupIds(BigInteger researcherId);
}

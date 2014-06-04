package edu.quark.systeminterfaces;

import java.math.BigInteger;
import java.util.List;

import edu.quark.datatypes.ResearcherDetails;

public interface ISearchResearcher {
	/** @return researcher id's*/
	List<BigInteger> getResearcherIds(ResearcherDetails details);
}

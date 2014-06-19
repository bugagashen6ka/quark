package edu.quark.systemlogic;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import edu.quark.businesslogic.ResearcherManager;
import edu.quark.datatypes.ResearcherDetails;
import edu.quark.systeminterfaces.ISearchResearcher;

@Stateless
@LocalBean
public class SearchResearcher implements ISearchResearcher {

	@EJB
	private ResearcherManager researcherManager;

	@Override
	public List<BigInteger> getResearcherIds(ResearcherDetails details) {
		return researcherManager.getResearcherIds(details);
	}
}

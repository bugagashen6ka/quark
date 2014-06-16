package edu.quark.systemlogic;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import edu.quark.businesslogic.GroupManager;
import edu.quark.businesslogic.ResearcherManager;
import edu.quark.datatypes.ResearcherDetails;

@Stateless
@LocalBean
public class ViewGroupMembers {
	@EJB
	private ResearcherManager researcherManager;
	@EJB
	private GroupManager groupManager;
	
	public List<ResearcherDetails> ViewMembers(BigInteger gid) {
		List<ResearcherDetails> retval = new ArrayList<ResearcherDetails>();
		try {
			for (BigInteger	rid : groupManager.getGroupDetails(gid).getMembers()) {
				retval.add(researcherManager.getResearcherDetails(rid));
			};			
		} catch (Exception e) {
			return new ArrayList<ResearcherDetails>();
		}
		return retval;
	}

}

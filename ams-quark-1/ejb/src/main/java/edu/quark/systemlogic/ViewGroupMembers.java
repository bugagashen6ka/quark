package edu.quark.systemlogic;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import edu.quark.businesslogic.GroupManager;
import edu.quark.businesslogic.ResearcherManager;

@Stateless
@LocalBean
public class ViewGroupMembers {
	@EJB
	private ResearcherManager researcherManager;
	@EJB
	private GroupManager groupManager;
	
	public List<String> ViewMembers(BigInteger gid) {
		List<String> retval = new ArrayList<String>();
		try {
			for (BigInteger	rid : groupManager.getGroupDetails(gid).getMembers()) {
				retval.add(researcherManager.getResearcherDetails(rid).toString());
			};			
		} catch (Exception e) {
			return new ArrayList<String>();
		}
		return retval;
	}

}

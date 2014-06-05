package edu.quark.systemlogic;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import edu.quark.businessinterfaces.IResearcherManagement;
import edu.quark.businesslogic.ResearcherManager;
import edu.quark.datatypes.ResearcherDetails;
import edu.quark.datatypes.TimeInfo;
import edu.quark.model.Researcher;

@Stateless
@LocalBean
public class SearchResearcher implements IResearcherManagement {

	@EJB
	private ResearcherManager researcherManager;

	@Override
	public List<BigInteger> getResearcherIds(ResearcherDetails details) {
		return researcherManager.getResearcherIds(details);
	}

	@Override
	public ResearcherDetails getResearcherDetails(BigInteger researcherId) {
		List<BigInteger> list = new ArrayList<BigInteger>();
		list.add(researcherId);

		List<ResearcherDetails> result = researcherManager
				.getResearcherDetails(list);

		if (result.size() != 1) {
			/* Should return exactly one researcher */
			return null;
		}

		return result.get(0);
	}

	@Override
	public List<ResearcherDetails> getResearcherDetails(
			List<BigInteger> researcherIds) {
		return researcherManager.getResearcherDetails(researcherIds);
	}

	@Override
	public List<BigInteger> getAppointmentIds(BigInteger researcherId,
			TimeInfo time) {
		return researcherManager.getAppointmentIds(researcherId, time);
	}

	@Override
	public boolean checkEmail(String email) {
		return researcherManager.checkEmail(email);
	}

	@Override
	public BigInteger createResearcher(String email, String password,
			String firstName, String lastName, String title, String phoneNumber) {
		return researcherManager.createResearcher(email, password, firstName,
				lastName, title, phoneNumber);
	}

	@Override
	public Researcher checkCredentials(String email, String password) {
		return researcherManager.checkCredentials(email, password);
	}

}

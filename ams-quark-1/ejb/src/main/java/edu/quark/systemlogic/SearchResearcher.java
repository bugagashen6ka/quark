package edu.quark.systemlogic;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Local;
import javax.enterprise.context.ApplicationScoped;

import edu.quark.businessinterfaces.IResearcherManagement;
import edu.quark.datatypes.ResearcherDetails;
import edu.quark.datatypes.TimeInfo;

@Local
@ApplicationScoped
public class SearchResearcher implements IResearcherManagement {

	@Override
	public List<BigInteger> getResearcherIds(ResearcherDetails details) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResearcherDetails getResearcherDetails(BigInteger researcherId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResearcherDetails> getResearcherDetails(
			List<BigInteger> researcherIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BigInteger> getAppointmentIds(BigInteger researcherId,
			TimeInfo time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BigInteger createResearcher(String email, String password,
			String firstName, String lastName, String title, String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkCredentials(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}

package edu.quark.businessinterfaces;

import java.math.BigInteger;
import java.util.List;

import edu.quark.datatypes.AppointmentDetails;
import edu.quark.datatypes.ResearcherDetails;
import edu.quark.datatypes.TimeInfo;
import edu.quark.model.Researcher;

public interface IResearcherManagement {
	/** @return researcher id's */
	List<BigInteger> getResearcherIds(ResearcherDetails details);

	ResearcherDetails getResearcherDetails(BigInteger researcherId);

	List<ResearcherDetails> getResearcherDetails(List<BigInteger> researcherIds);

	/** @return appointment id's */
	List<AppointmentDetails> getAppointmentDetails(BigInteger researcherId, TimeInfo time);

	Researcher checkEmail(String email);

	/** @return researcher id */
	BigInteger createResearcher(String email, String password,
			String firstName, String lastName, String title, String phoneNumber);

	Researcher checkCredentials(String email, String password);
}

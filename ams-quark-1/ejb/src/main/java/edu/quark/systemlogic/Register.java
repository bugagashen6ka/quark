package edu.quark.systemlogic;

import java.math.BigInteger;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import edu.quark.businesslogic.ResearcherManager;
import edu.quark.systeminterfaces.IRegister;

@Stateless
@LocalBean
public class Register implements IRegister {

	@EJB
	private ResearcherManager researcherManager;

	@Override
	public boolean checkEmail(String email) {
		return researcherManager.checkEmail(email) != null;
	}

	@Override
	public BigInteger createResearcher(String email, String password,
			String firstName, String lastName, String title, String phoneNumber) {
		return researcherManager.createResearcher(email, password, firstName,
				lastName, title, phoneNumber);
	}

}

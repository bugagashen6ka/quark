package edu.quark.systemlogic;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import edu.quark.businesslogic.ResearcherManager;
import edu.quark.model.Researcher;
import edu.quark.systeminterfaces.ILogin;

@Stateless
@LocalBean
public class Login implements ILogin {

	@EJB
	private ResearcherManager researcherManager;

	@Override
	public Researcher login(String email, String password) {
		return researcherManager.checkCredentials(email, password);
	}

}

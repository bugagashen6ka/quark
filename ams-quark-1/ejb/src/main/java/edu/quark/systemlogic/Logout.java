package edu.quark.systemlogic;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import edu.quark.model.Researcher;
import edu.quark.systeminterfaces.ILogout;

@Stateless
@LocalBean
public class Logout implements ILogout {

	@Override
	public boolean logout(Researcher researcher) {
		// TODO Auto-generated method stub
		return false;
	}

}

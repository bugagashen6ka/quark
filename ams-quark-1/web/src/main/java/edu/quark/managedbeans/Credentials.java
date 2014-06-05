package edu.quark.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.ejb.EJB;
import edu.quark.model.Researcher;
import edu.quark.systemlogic.Login;
import edu.quark.systemlogic.Logout;

@ManagedBean
@SessionScoped
public class Credentials {

	@EJB
	private Login login;
	@EJB
	private Logout logout;

	private String email;
	private String password;
	private Researcher researcher;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Researcher getResearcher() {
		return researcher;
	}

	public void setResearcher(Researcher researcher) {
		this.researcher = researcher;
	}

	public void login() {
		setResearcher(login.login(email, password));
	}

	public void logout() {
		logout.logout(researcher);
		setResearcher(null);
	}
}

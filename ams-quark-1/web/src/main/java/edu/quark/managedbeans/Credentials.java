package edu.quark.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import edu.quark.dao.ResearcherDAO;
import edu.quark.model.Researcher;
import edu.quark.systemlogic.Login;
import edu.quark.systemlogic.Logout;
import edu.quark.systemlogic.Register;

@ManagedBean
@SessionScoped
public class Credentials {

	@EJB
	private Login login;
	@EJB
	private Logout logout;
	@EJB
	private Register register;

	@EJB
	private ResearcherDAO researcherDAO;

	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String title;

	private Researcher researcher;

	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean;

	@PostConstruct
	public void init() {
		Researcher researcher2 = new Researcher();
		researcher2.setEmail("email");
		researcher2.setPassword("1");
		researcher2.setFirstName("vas");
		researcher2.setLastName("pup");
		researcher2.setPhoneNumber("1111");
		researcher2.setTitle("Dr.");
		researcherDAO.create(researcher2);
	}

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

	public String login() {
		setResearcher(login.login(email, password));
		if (researcher == null) {
			return "failure";
		}
		navigationBean.moveToCalendar();
		return "success";
	}

	public void logout() {
		logout.logout(researcher);
		setResearcher(null);
	}

	public void register() {
		register.createResearcher(email, password, firstName, lastName, title,
				phoneNumber);
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Logout getLogout() {
		return logout;
	}

	public void setLogout(Logout logout) {
		this.logout = logout;
	}

	public ResearcherDAO getResearcherDAO() {
		return researcherDAO;
	}

	public void setResearcherDAO(ResearcherDAO researcherDAO) {
		this.researcherDAO = researcherDAO;
	}

	public NavigationBean getNavigationBean() {
		return navigationBean;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}

	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}

package edu.quark.managedbeans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import edu.quark.dao.ResearcherDAO;
import edu.quark.datatypes.ResearcherDetails;
import edu.quark.model.Researcher;
import edu.quark.systemlogic.Login;
import edu.quark.systemlogic.Logout;
import edu.quark.systemlogic.Register;

@ManagedBean
@SessionScoped
@Path("/")
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
		researcher2.setEmail("email@acm.org");
		researcher2.setPassword("1");
		researcher2.setFirstName("Vasilii");
		researcher2.setLastName("Pupkin");
		researcher2.setPhoneNumber("1111");
		researcher2.setTitle("Dr.");
		researcherDAO.create(researcher2);
		
		researcher2 = new Researcher();
		researcher2.setEmail("quark@at.net");
		researcher2.setPassword("1");
		researcher2.setFirstName("Speise");
		researcher2.setLastName("Quarkstein");
		researcher2.setPhoneNumber("1111");
		researcher2.setTitle("Prof.");
		researcherDAO.create(researcher2);
		
		researcher2 = new Researcher();
		researcher2.setEmail("dima");
		researcher2.setPassword("1");
		researcher2.setFirstName("Alex");
		researcher2.setLastName("Planeta");
		researcher2.setPhoneNumber("Martin");
		researcher2.setTitle("Trach");
		researcherDAO.create(researcher2);
		
		researcher2 = new Researcher();
		researcher2.setEmail("apfel");
		researcher2.setPassword("1");
		researcher2.setFirstName("Apfel");
		researcher2.setLastName("Saft");
		researcher2.setPhoneNumber("1111");
		researcher2.setTitle("Prof.");
		researcherDAO.create(researcher2);

		researcher = researcher2;
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

	public String logout() {
		logout.logout(researcher);
		setResearcher(null);
		return navigationBean.moveToLogin();
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

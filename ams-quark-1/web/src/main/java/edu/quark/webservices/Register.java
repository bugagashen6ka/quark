package edu.quark.webservices;

import java.math.BigInteger;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;

@Path("/Register")
@Produces(MediaType.APPLICATION_JSON)
public class Register{

	@EJB
	private edu.quark.systemlogic.Register register;

	@GET
	@Path("checkEmail.json")
	public boolean checkEmail(String email) {
		return register.checkEmail(email);
	}

	@POST
	@Path("/createResearcher.json")
	public BigInteger createResearcher(@QueryParam("email") String email,
			@QueryParam("password") String password,
			@QueryParam("firstName") String firstName,
			@QueryParam("lastName") String lastName,
			@QueryParam("title") String title,
			@QueryParam("phoneNumber") String phoneNumber) {
		return register.createResearcher(email, password, firstName, lastName,
				title, phoneNumber);
	}

}

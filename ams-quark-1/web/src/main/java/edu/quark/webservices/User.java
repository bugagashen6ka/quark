package edu.quark.webservices;

import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.HeaderParam;
import javax.xml.ws.spi.http.HttpContext;

import javax.xml.bind.DatatypeConverter;

import edu.quark.dao.ResearcherDAO;
import edu.quark.model.Researcher;
import edu.quark.systemlogic.Login;
import edu.quark.systemlogic.Logout;
import edu.quark.systemlogic.Register;

@Stateless
@Path("/")
public class User {
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
	
	private boolean checkCredentials(HttpHeaders httpHeaders) {
		List<String> values = httpHeaders.getRequestHeader(HttpHeaders.AUTHORIZATION);
		if (!values.get(0).startsWith("Basic "))
			return false;
		String token = values.get(0).substring("Basic ".length());
		byte[] decoded = DatatypeConverter.parseBase64Binary(token);
		String email, password;
		
		// Go since 1 because if ':" is first symbol than no email has been provided
		// Go until -1 because if ':" is last symbol than no password has been provided
		for (int i = 1; i < decoded.length - 1; i++)
			if (decoded[i] == ':') {
				email = new String(Arrays.copyOf(decoded, i));
				password = new String(Arrays.copyOfRange(decoded, i + 1, decoded.length));
				
				Researcher res = login.login(email, password);
				if (res != null)
					return true;
				return false;
			}
		return false;
	}
	
	@POST
	@Path("/login.json")
	public Response login(
			@QueryParam("email") String email, 
			@QueryParam("password") String password) {
		if (researcher == null) {
			return Response.serverError().status(Status.UNAUTHORIZED).build();
		}
		return Response.ok().build();
	}
	
	@GET
	@Path("/test.json")
	@Produces(MediaType.APPLICATION_JSON)
	public Researcher test() {
		Researcher researcher2 = new Researcher();
		researcher2.setEmail("apfel");
		researcher2.setPassword("1");
		researcher2.setFirstName("Apfel");
		researcher2.setLastName("Saft");
		researcher2.setPhoneNumber("1111");
		researcher2.setTitle("Prof.");
		researcherDAO.create(researcher2);

		researcher = researcher2;
		
		
		return researcher;
	}

	@POST
	@Path("/echo.json")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_JSON)
	public Researcher echo(@Context HttpHeaders httpHeaders, Researcher in) {
		if (!checkCredentials(httpHeaders))
			return null;
//		if (!httpContext.getAttribute("Authorization")) {
//			return null;
//		}
//		
//		String email = securityContext.getUserPrincipal().getName();
//		String password = sec
		return in;
	}
}

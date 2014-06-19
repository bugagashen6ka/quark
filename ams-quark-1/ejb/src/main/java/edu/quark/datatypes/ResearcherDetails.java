package edu.quark.datatypes;

import java.math.BigInteger;

import edu.quark.model.Researcher;

public class ResearcherDetails {
	public ResearcherDetails(BigInteger rId, String emailAddress,
			String firstName, String lastName, String title, String phoneNbr) {
		super();
		this.rId = rId;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.phoneNbr = phoneNbr;
	}

	public ResearcherDetails(Researcher r) {
		super();
		this.rId = r.getRid();
		this.emailAddress = r.getEmail();
		this.firstName = r.getFirstName();
		this.lastName = r.getLastName();
		this.title = r.getTitle();
		this.phoneNbr = r.getPhoneNumber();
	}

	private BigInteger rId;
	private String emailAddress;
	private String firstName;
	private String lastName;
	private String title;
	private String phoneNbr;

	@Override
	public String toString() {
		return title + " " + firstName + " " + lastName;
	}

	public BigInteger getrId() {
		return rId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getTitle() {
		return title;
	}

	public String getPhoneNbr() {
		return phoneNbr;
	}

	public ResearcherDetails() {
	}
}

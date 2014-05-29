package edu.quark.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Researcher
 * 
 */
@Entity
@Table(name = "Researcher")
public class Researcher implements Serializable {

	@Id
	@Column(name = "rid", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger rId;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "firstName", nullable = false)
	private String firstName;

	@Column(name = "lastName", nullable = false)
	private String lastName;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "phoneNumber", nullable = false)
	private String phoneNumber;

	@OneToOne(mappedBy = "creator")
	private Appointment appointment;

	@ManyToMany
	@JoinTable(name = "Researcher_Appointment", joinColumns = { @JoinColumn(name = "rid", referencedColumnName = "rid") }, inverseJoinColumns = { @JoinColumn(name = "aid", referencedColumnName = "aid") })
	private Set<Appointment> appointments;

	private static final long serialVersionUID = 1L;

	public Researcher() {
		super();
	}

	public BigInteger getrId() {
		return rId;
	}

	public void setrId(BigInteger rId) {
		this.rId = rId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}

}
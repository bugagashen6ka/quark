package edu.quark.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Researcher
 * 
 */
@Entity
@Table(name = "Researcher")
@NamedQueries({ @NamedQuery(name = "Researcher.findAll", query = "SELECT r FROM Researcher r") })
public class Researcher implements Serializable {

	@Id
	@Column(name = "rid", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger rid;

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

	@OneToMany(mappedBy = "creator")
	// one researcher can create many groups
	// @JoinTable needed?
	private Set<Group> createdGroups;

	@OneToMany(mappedBy = "creator")
	// one researcher can create many appointments
	// @JoinTable needed?
	private Set<Appointment> createdAppointments;

	@ManyToMany
	@JoinTable(name = "Researcher_Appointment", joinColumns = { @JoinColumn(name = "rid", referencedColumnName = "rid") }, inverseJoinColumns = { @JoinColumn(name = "aid", referencedColumnName = "aid") })
	private Set<Appointment> appointments;

	private static final long serialVersionUID = 1L;

	public Researcher() {
		super();
	}

	public BigInteger getRid() {
		return rid;
	}

	public void setRid(BigInteger rid) {
		this.rid = rid;
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

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Set<Group> getCreatedGroups() {
		return createdGroups;
	}

	public void setCreatedGroups(Set<Group> createdGroups) {
		this.createdGroups = createdGroups;
	}

	public Set<Appointment> getCreatedAppointments() {
		return createdAppointments;
	}

	public void setCreatedAppointments(Set<Appointment> createdAppointments) {
		this.createdAppointments = createdAppointments;
	}

}
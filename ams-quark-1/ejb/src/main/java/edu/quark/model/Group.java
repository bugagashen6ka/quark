package edu.quark.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Group
 * 
 */
@Entity
@Table(name = "GroupTable")
@Inheritance(strategy=InheritanceType.JOINED)
public class Group implements Serializable {

	@Id
	@Column(name = "gid", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger gid;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "password", nullable = false)
	private String password;

	@OneToMany(mappedBy="group")
	// one group can have many appointments associated with it
	// Do we need to declare this end of the association? I am not sure we need
	// to display appointments
	// from the perspective of groups.
	private Set<Appointment> appointments;

	@ManyToOne
	// one researcher can create many groups
	// @JoinTable needed?
	@JoinColumn(name = "rid")
	private Researcher creator;

	@ManyToMany
	@JoinTable(name = "Group_members", joinColumns = { @JoinColumn(name = "gid", referencedColumnName = "gid") }, inverseJoinColumns = { @JoinColumn(name = "rid", referencedColumnName = "rid") })
	private Set<Researcher> members = new HashSet<Researcher>();

	private static final long serialVersionUID = 1L;

	public Group() {
		super();
	}

	public BigInteger getGid() {
		return gid;
	}

	public void setGid(BigInteger gid) {
		this.gid = gid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Researcher getCreator() {
		return creator;
	}

	public void setCreator(Researcher creator) {
		this.creator = creator;
	}

	public Set<Researcher> getMembers() {
		return members;
	}

	public void setMembers(Set<Researcher> members) {
		this.members = members;
	}

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

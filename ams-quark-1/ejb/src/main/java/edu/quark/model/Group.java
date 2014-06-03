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
@Table(name = "Group")
public class Group implements Serializable {

	@Id
	@Column(name = "gid", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger gId;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "password", nullable = false)
	private String password;

	@OneToOne
	@JoinColumn(name = "rid")
	private Researcher creator;

	@ManyToMany
	@JoinTable(name = "Group_members", joinColumns = { @JoinColumn(name = "gid", referencedColumnName = "gid") }, inverseJoinColumns = { @JoinColumn(name = "rid", referencedColumnName = "rid") })
	private Set<Researcher> members = new HashSet<Researcher>();

	private static final long serialVersionUID = 1L;

	public Group() {
		super();
	}

	public BigInteger getgId() {
		return gId;
	}

	public void setgId(BigInteger gId) {
		this.gId = gId;
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
   
}

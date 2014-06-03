package edu.quark.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Appointment
 * 
 */
@Entity
@Table(name = "Appointment")
public class Appointment implements Serializable {

	@Id
	@Column(name = "aid", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger aId;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "location", nullable = false)
	private String location;

	/*
	 * not sure how to implement TimeInfo in the DB, believe that this is the
	 * simplest way
	 */
	@Column(name = "start")
	private Date start;

	@Column(name = "end")
	private Date end;

	@OneToOne
	@JoinColumn(name = "rid")
	private Researcher creator;

	@ManyToMany(mappedBy = "appointments", cascade = CascadeType.ALL)
	private Set<Researcher> participants = new HashSet<Researcher>();

	private static final long serialVersionUID = 1L;

	public Appointment() {
		super();
	}

	public BigInteger getaId() {
		return aId;
	}

	public void setaId(BigInteger aId) {
		this.aId = aId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Researcher getCreator() {
		return creator;
	}

	public void setCreator(Researcher creator) {
		this.creator = creator;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<Researcher> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<Researcher> participants) {
		this.participants = participants;
	}

}

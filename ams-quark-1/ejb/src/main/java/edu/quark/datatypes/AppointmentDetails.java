package edu.quark.datatypes;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import edu.quark.model.Appointment;
import edu.quark.model.Researcher;

public class AppointmentDetails {
	
	public AppointmentDetails(BigInteger aId, TimeInfo timeInterval,
			String location, String description, Set<BigInteger> participants) {
		super();
		this.aId = aId;
		this.timeInterval = timeInterval;
		this.location = location;
		this.description = description;
		this.participants = participants;
	}
	public AppointmentDetails(Appointment a) {
		super();
		this.aId = a.getAid();
		this.timeInterval = new TimeInfo(a.getStart(), a.getEnd());
		this.location = a.getLocation();
		this.description = a.getDescription();
		this.participants = new HashSet<BigInteger>();
		for (Researcher r: a.getParticipants()) {
			this.participants.add(r.getRid());
		}
	}
	
	private BigInteger aId;
	private TimeInfo timeInterval;
	private String location;
	private String description;
	private Set<BigInteger> participants;
	public BigInteger getaId() {
		return aId;
	}
	public TimeInfo getTimeInterval() {
		return timeInterval;
	}
	public String getLocation() {
		return location;
	}
	public String getDescription() {
		return description;
	}
	public Set<BigInteger> getParticipants() {
		return participants;
	}
}

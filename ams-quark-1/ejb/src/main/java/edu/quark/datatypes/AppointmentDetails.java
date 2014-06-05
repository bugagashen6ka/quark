package edu.quark.datatypes;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import edu.quark.model.Appointment;
import edu.quark.model.ConferenceAppointment;
import edu.quark.model.ProjectGroupMeeting;
import edu.quark.model.ResearchGroupMeeting;
import edu.quark.model.Researcher;
import edu.quark.model.TeachingAppointment;

public class AppointmentDetails {
	public AppointmentDetails(AppointmentType type, BigInteger aId,
			TimeInfo timeInterval, String location, String description,
			Set<BigInteger> participants) {
		super();
		this.type = type;
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
		if (a.getClass()==Appointment.class) {
			this.type=AppointmentType.GENERIC_APPOINTMENT;
		} else if (a.getClass()==ConferenceAppointment.class) {
			this.type=AppointmentType.CONFERENCE_APPOINTMENT;
		} else if (a.getClass()==ProjectGroupMeeting.class) {
			this.type=AppointmentType.PROJECT_GROUP_MEETING;
		} else if (a.getClass()==ResearchGroupMeeting.class) {
			this.type=AppointmentType.RESEARCH_GROUP_MEETING;
		} else if (a.getClass()==TeachingAppointment.class) {
			this.type=AppointmentType.TEACHING_APPOINTMENT;
		}
	}
	
	private AppointmentType type;
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
	public AppointmentType getType() {
		return type;
	}
	public void setType(AppointmentType type) {
		this.type = type;
	}
}

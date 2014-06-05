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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aId == null) ? 0 : aId.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result
				+ ((participants == null) ? 0 : participants.hashCode());
		result = prime * result
				+ ((timeInterval == null) ? 0 : timeInterval.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppointmentDetails other = (AppointmentDetails) obj;
		if (aId == null) {
			if (other.aId != null)
				return false;
		} else if (!aId.equals(other.aId))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (participants == null) {
			if (other.participants != null)
				return false;
		} else if (!participants.equals(other.participants))
			return false;
		if (timeInterval == null) {
			if (other.timeInterval != null)
				return false;
		} else if (!timeInterval.equals(other.timeInterval))
			return false;
		if (type != other.type)
			return false;
		return true;
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

package edu.quark.model;

import edu.quark.model.Group;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ResearchGroup
 * 
 */
@Entity
@Table(name = "ResearchGroup")
public class ResearchGroup extends Group implements Serializable {

	@OneToMany(mappedBy = "researchGroup")
	private Set<ResearchGroupMeeting> researchGroupMeetings;
	private static final long serialVersionUID = 1L;

	public ResearchGroup() {
		super();
	}

	public Set<ResearchGroupMeeting> getResearchGroupMeetings() {
		return researchGroupMeetings;
	}

	public void setResearchGroupMeetings(
			Set<ResearchGroupMeeting> researchGroupMeetings) {
		this.researchGroupMeetings = researchGroupMeetings;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

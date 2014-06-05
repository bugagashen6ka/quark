package edu.quark.model;

import edu.quark.model.Appointment;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ResearchGroupMeeting
 * 
 */
@Entity
public class ResearchGroupMeeting extends Appointment implements Serializable {

	@ManyToOne
	@JoinColumn(name = "gid")
	private ResearchGroup researchGroup;

	private static final long serialVersionUID = 1L;

	public ResearchGroupMeeting() {
		super();
	}

	public ResearchGroup getResearchGroup() {
		return researchGroup;
	}

	public void setResearchGroup(ResearchGroup researchGroup) {
		this.researchGroup = researchGroup;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

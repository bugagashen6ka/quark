package edu.quark.model;

import edu.quark.model.Group;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ProjectGroup
 * 
 */
@Entity
public class ProjectGroup extends Group implements Serializable {

	@OneToMany(mappedBy = "projectGroup")
	private Set<ProjectGroupMeeting> projectGroupMeetings;

	private static final long serialVersionUID = 1L;

	public ProjectGroup() {
		super();
	}

	public Set<ProjectGroupMeeting> getProjectGroupMeetings() {
		return projectGroupMeetings;
	}

	public void setProjectGroupMeetings(
			Set<ProjectGroupMeeting> projectGroupMeetings) {
		this.projectGroupMeetings = projectGroupMeetings;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

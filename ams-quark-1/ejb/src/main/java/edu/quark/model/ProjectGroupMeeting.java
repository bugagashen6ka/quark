package edu.quark.model;

import edu.quark.model.Appointment;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ProjectMeeting
 * 
 */
@Entity
public class ProjectGroupMeeting extends Appointment implements Serializable {

	@ManyToOne
	@JoinColumn(name = "gid")
	private ProjectGroup projectGroup;

	private static final long serialVersionUID = 1L;

	public ProjectGroupMeeting() {
		super();
	}

	public ProjectGroup getProjectGroup() {
		return projectGroup;
	}

	public void setProjectGroup(ProjectGroup projectGroup) {
		this.projectGroup = projectGroup;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

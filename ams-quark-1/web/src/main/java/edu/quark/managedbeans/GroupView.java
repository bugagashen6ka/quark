package edu.quark.managedbeans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.quark.dao.GroupDAO;
import edu.quark.dao.ResearcherDAO;
import edu.quark.datatypes.GroupType;
import edu.quark.model.Appointment;
import edu.quark.model.Group;
import edu.quark.systemlogic.CreateGroup;
import edu.quark.systemlogic.JoinGroup;
import edu.quark.systemlogic.LeaveGroup;
import edu.quark.systemlogic.SearchAppointment;
import edu.quark.systemlogic.Time;

@ViewScoped
@ManagedBean
public class GroupView {

	@EJB
	private GroupDAO groupDAO;
	@EJB
	private ResearcherDAO researcherDAO;
	@EJB
	private CreateGroup createGroup;
	@EJB
	private SearchAppointment searchAppointment;
	@EJB
	private Time time;
	@EJB
	private JoinGroup joinGroup;
	@EJB
	private LeaveGroup leaveGroup;

	private java.util.List<Group> groups;
	private Group selectedGroup;
	private GroupType selectedGroupType;
	private String password;
	

	@PostConstruct
	public void init() {
		groups = groupDAO.findAll();
	}

	public GroupDAO getGroupDAO() {
		return groupDAO;
	}

	public void setGroupDAO(GroupDAO groupDAO) {
		this.groupDAO = groupDAO;
	}

	public java.util.List<Group> getGroups() {
		return groups;
	}

	public void setGroups(java.util.List<Group> groups) {
		this.groups = groups;
	}

	public void createGroup() {
		createGroup.createGroup(selectedGroup.getName(), selectedGroupType);
	}

	
	public void joinGroup() {
		//joinGroup.join(rid, password);
	}

	
	public void leaveGroup(){
		//leaveGroup.leave(rid, selectedGroup.getGid());
	}

}

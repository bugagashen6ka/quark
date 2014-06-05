package edu.quark.managedbeans;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.quark.dao.GroupDAO;
import edu.quark.dao.ResearcherDAO;
import edu.quark.datatypes.GroupDetails;
import edu.quark.datatypes.GroupType;
import edu.quark.model.Group;
import edu.quark.systemlogic.CreateGroup;
import edu.quark.systemlogic.JoinGroup;
import edu.quark.systemlogic.LeaveGroup;
import edu.quark.systemlogic.SearchAppointment;
import edu.quark.systemlogic.SearchGroup;
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
	private SearchGroup searchGroup;
	@EJB
	private Time time;
	@EJB
	private JoinGroup joinGroup;
	@EJB
	private LeaveGroup leaveGroup;
	@ManagedProperty(value = "#{credentials}")
	private Credentials credentials;

	private Group newGroup;
	private List<Group> groups;
	private List<GroupDetails> researcherGroupDetails;
	private Group selectedGroup;
	private GroupType selectedGroupType;
	private String password;
	private GroupType groupType;
	private Group chosenGroup;
	private BigInteger selectedGroupId;

	@PostConstruct
	public void init() {
		groups = groupDAO.findAll();

		updateResearcherGroups();

		researcherGroupDetails = new ArrayList<GroupDetails>();
		GroupDetails detail;
		for (Integer i = 0; i < 5; i++) {
			detail = new GroupDetails(BigInteger.valueOf(i), "group" + i.toString(), GroupType.PROJECT_GROUP, null);
			researcherGroupDetails.add(detail);
		}
		newGroup = new Group();
		chosenGroup = new Group();
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

	public void createGroupMethod() {
		createGroup.createGroup(credentials.getResearcher(),
				newGroup.getName(), groupType, newGroup.getPassword());
		groups = groupDAO.findAll();
	}

	public void joinGroupMethod() {
		joinGroup.join(credentials.getResearcher(),
				chosenGroup.getGid(), chosenGroup.getPassword());
		updateResearcherGroups();
	}

	public void leaveGroupMethod() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		String groupString = params.get("selectedGroupId");
		System.out.println("Try to leave group " + groupString);
		if (groupString != null) {
			selectedGroupId = new BigInteger(groupString);
			leaveGroup.leave(credentials.getResearcher().getRid(), selectedGroupId);
		}
		System.out.println("Try to leave group " + selectedGroupId + " | " + groupString);
		updateResearcherGroups();
	}

	public ResearcherDAO getResearcherDAO() {
		return researcherDAO;
	}

	public void setResearcherDAO(ResearcherDAO researcherDAO) {
		this.researcherDAO = researcherDAO;
	}

	public CreateGroup getCreateGroup() {
		return createGroup;
	}

	public void setCreateGroup(CreateGroup createGroup) {
		this.createGroup = createGroup;
	}

	public SearchAppointment getSearchAppointment() {
		return searchAppointment;
	}

	public void setSearchAppointment(SearchAppointment searchAppointment) {
		this.searchAppointment = searchAppointment;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public JoinGroup getJoinGroup() {
		return joinGroup;
	}

	public void setJoinGroup(JoinGroup joinGroup) {
		this.joinGroup = joinGroup;
	}

	public LeaveGroup getLeaveGroup() {
		return leaveGroup;
	}

	public void setLeaveGroup(LeaveGroup leaveGroup) {
		this.leaveGroup = leaveGroup;
	}

	public Group getSelectedGroup() {
		return selectedGroup;
	}

	public void setSelectedGroup(Group selectedGroup) {
		this.selectedGroup = selectedGroup;
	}

	public GroupType getSelectedGroupType() {
		return selectedGroupType;
	}

	public void setSelectedGroupType(GroupType selectedGroupType) {
		this.selectedGroupType = selectedGroupType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Group getNewGroup() {
		return newGroup;
	}

	public void setNewGroup(Group newGroup) {
		this.newGroup = newGroup;
	}

	public GroupType getGroupType() {
		return groupType;
	}

	public void setGroupType(GroupType groupType) {
		this.groupType = groupType;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public Group getChosenGroup() {
		return chosenGroup;
	}

	public void setChosenGroup(Group chosenGroup) {
		this.chosenGroup = chosenGroup;
	}
	
	public List<GroupDetails> getResearcherGroupDetails() {
		return researcherGroupDetails;
	}

	public void setResearcherGroupDetails(List<GroupDetails> researcherGroups) {
		this.researcherGroupDetails = researcherGroups;
	}

	public void updateResearcherGroups() {
		researcherGroupDetails = searchGroup.getGroupDetails(credentials.getResearcher());
	}

	public BigInteger getSelectedGroupId() {
		return selectedGroupId;
	}

	public void setSelectedGroupId(BigInteger selectedGroupId) {
		this.selectedGroupId = selectedGroupId;
	}

}

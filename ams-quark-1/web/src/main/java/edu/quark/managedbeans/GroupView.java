package edu.quark.managedbeans;

import java.math.BigInteger;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.quark.dao.GroupDAO;
import edu.quark.dao.ResearcherDAO;
import edu.quark.model.Group;
import edu.quark.model.Researcher;


@ViewScoped
@ManagedBean
public class GroupView {
	
	@EJB
	private GroupDAO groupDAO;
	@EJB
	private ResearcherDAO researcherDAO;
	
	private java.util.List<Group> groups;
	
	@PostConstruct
	public void init(){
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
	
	

}

package edu.quark.managedbeans;

import java.math.BigInteger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.quark.dao.GroupDAO;
import edu.quark.model.Group;

@ViewScoped
@ManagedBean
public class BasicView {
	@EJB
	private GroupDAO groupDAO;

	private Group group;
	private Group group2;
	private String text;

	@PostConstruct
	public void init() {
		group = new Group();
		group2 = new Group();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public GroupDAO getGroupDAO() {
		return groupDAO;
	}

	public Group getGroup2() {
		return group2;
	}

	public void setGroup2(Group group2) {
		this.group2 = group2;
	}

	public void addGroup() {
		groupDAO.create(group);
	}

	public void setGroupDAO(GroupDAO groupDAO) {
		this.groupDAO = groupDAO;
		group2 = groupDAO.read(BigInteger.ZERO);
	}

}
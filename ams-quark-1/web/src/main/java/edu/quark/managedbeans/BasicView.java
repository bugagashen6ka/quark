package edu.quark.managedbeans;

import java.math.BigInteger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.application.FacesMessage;

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
	private BigInteger id;
	
	@PostConstruct
	public void init(){
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
		addMessage(group.getName());
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
		System.out.println("add group " + group.getName() + " | " + group.getPassword());
		id = groupDAO.create(group);
		System.out.println("add group 7 " + id.toString());
		System.out.println("add group end");
	}
	
	public void showGroup() {
		addMessage("Welcome to Primefaces!!");
		System.out.println("show group start");
		group2 = groupDAO.read(id);
		System.out.println("show group " + group2.getName());
		addMessage(group.toString()+ "Try to read group");
	}
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
	public void setGroupDAO(GroupDAO groupDAO) {
		this.groupDAO = groupDAO;
	}
	
    public void buttonAction(ActionEvent actionEvent) {
        addMessage("Welcome to Primefaces!!");
    }

}
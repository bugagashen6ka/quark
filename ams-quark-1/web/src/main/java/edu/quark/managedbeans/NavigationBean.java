package edu.quark.managedbeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class NavigationBean {

	private String page;
	@PostConstruct
	public void init(){
		this.page = "/index.xhtml";
	}

	public String moveToCalendar() {
		this.page = "/calendar.xhtml";
		return "success";
	}

	public String moveToLogin() {
		this.page = "/index.xhtml";
		return "success";
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	
}

package edu.quark.managedbeans;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@Named @RequestScoped
public class Credentials {
	
	private String username = "Email";
    private String password = "Password";

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

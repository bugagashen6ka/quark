package edu.quark.managedbeans;

import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@Named @SessionScoped
public class Credentials {
	
	private String username;
    private String password;
    private Boolean logedIn;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public Boolean getLogedIn() { return logedIn; }
    public void setLogedIn(Boolean logedIn) { this.logedIn = logedIn; }
}

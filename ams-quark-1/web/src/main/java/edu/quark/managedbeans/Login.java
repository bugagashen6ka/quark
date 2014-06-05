package edu.quark.managedbeans;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.quark.managedbeans.Credentials;

@SessionScoped @Named
public class Login {

    Credentials credentials;
    @PersistenceContext EntityManager userDatabase;


    public void login() {
/*        List<User> results = userDatabase.createQuery(
           "select u from User u where u.username=:username and u.password=:password")
           .setParameter("username", credentials.getUsername())
           .setParameter("password", credentials.getPassword())
           .getResultList();
        
        if ( !results.isEmpty() ) {
           user = results.get(0);
        }*/
    }
    
    public void register() {
    	
    	
    	
    }

/*    public bool@Current Credentials credentials;
    @PersistenceContext EntityManager userDatabase;*/


/*    public boolean isLoggedIn() {
       return user!=null;
    }*/

/*    @Produces @LoggedIn User getCurrentUser() {
        return user;
    }ean isLoggedIn() {
       return user!=null;
    }*/

/*    @Produces @LoggedIn User getCurrentUser() {
        return user;
    }*/
}

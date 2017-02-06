package fr.philae.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import fr.philae.busmapper.domain.Feed;
import fr.philae.busmapper.domain.Stops;
import fr.philae.busmapper.domain.User;
import fr.philae.busmapper.services.gestion.feed.FeedServicesLocal;
import fr.philae.busmapper.services.gestion.stop.StopServicesLocal;
import fr.philae.busmapper.services.gestion.user.UserServicesLocal;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 71207265440168749L;
	@EJB
	private UserServicesLocal userServicesLocal;


	

	private String login;
	private String password;
	private Boolean userConnected = false;
	private String navigateTo;

	// start userdashboard
	private String userStation;
	private String email;
	private String fullname;

	private String emailUpdate;

	private static User userOnline;

	private List<User> myusers;

	public    User user2;

	
	User userToUpdate;
	Stops stop1;
	
	@PostConstruct
	public void init()
	{	
	user2=new User();
	System.out.println("loo "+user2.getUserName());
	}

	

	// LOG IN
	public String doLogin() {

		

		userOnline = new User();

		boolean loggedIn = false;

		// Authentification
		
		if (userServicesLocal.authentificate(login, password) != null) {
			user2=new User();
			user2=userServicesLocal.authentificate(login, password);
			userConnected = true;
			userOnline = user2;

			System.out.println("le nom de user2 est " + user2.getUserName());
			// init for the user dashboard
			fullname = user2.getFullName();
			userStation = user2.getStationFollow();
			email = user2.getEmail();

			System.out.println("OK loto");
			navigateTo = "mapsUser?faces-redirect=true";
			return navigateTo;
		} else {
            
			System.out.println("Erreur ...add");
			navigateTo = "espace?faces-redirect=true";
			return navigateTo;

		}

	}
	
	
	public String updtae() {
		userToUpdate = new User();
		userToUpdate = user2;
		//userToUpdate.setEmail(emailUpdate);
        userToUpdate.setStationFollow(userStation);
		System.out.println("entré updateavec email user2" + user2.getEmail());

		userServicesLocal.updateUser(userToUpdate);
		System.out.println("sortie update avec email user2"
				+ userToUpdate.getEmail());
		return "mapsUser?faces-redirect=true";
	}

	// LOG OUT
	public String doDisconnect() {
		System.out.println("début disconnecte" + user2.getFullName());
		navigateTo = "loginboot.jsf?faces-redirect=true";
		userConnected = false;
		user2 = new User();
		System.out.println("fin disconnecte" + user2.getFullName());
	
		return navigateTo;
	}

	// the connected user
	public User whoAmI() {
		return user2;
	}
	
	
	

	// redirect To Login
	public String redirectToLogin() {
		return "loginboot?faces-redirect=true";
	}

	
	
	
	
	
	// GETTER & SETTER

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UserServicesLocal getUserServicesLocal() {
		return userServicesLocal;
	}

	public void setUserServicesLocal(UserServicesLocal userServicesLocal) {
		this.userServicesLocal = userServicesLocal;
	}

	public String getNavigateTo() {
		return navigateTo;
	}

	public void setNavigateTo(String navigateTo) {
		this.navigateTo = navigateTo;
	}

	public Boolean getUserConnected() {
		return userConnected;
	}

	public void setUserConnected(Boolean userConnected) {
		this.userConnected = userConnected;
	}

	public List<User> getMyusers() {
		return myusers;
	}

	public void setMyusers(List<User> myusers) {
		this.myusers = myusers;
	}

	public static User getUserOnline() {
		return userOnline;
	}

	public static void setUserOnline(User userOnline) {
		LoginBean.userOnline = userOnline;
	}

	public String getUserStation() {
		return userStation;
	}

	public void setUserStation(String userStation) {
		this.userStation = userStation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}



	public String getEmailUpdate() {
		return emailUpdate;
	}

	public void setEmailUpdate(String emailUpdate) {
		this.emailUpdate = emailUpdate;
	}





    public User getUser2() {
		return user2;
	}



	public void setUser2(User user2) {
		this.user2 = user2;
	}



	public void save() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("The username and password that you entered did not match our records. Please double-check and try again."));
    }
}

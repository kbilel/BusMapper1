package fr.philae.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.philae.busmapper.domain.User;
import fr.philae.busmapper.services.gestion.user.UserServicesLocal;
@ManagedBean
@ViewScoped
public class CustomerBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	UserServicesLocal local;
	Boolean form;
	private List<User> UsersFiltred;
	
	private List<User> Users=new ArrayList<User>();
	private User User=new User();
	
	
	public Boolean getForm() {
		return form;
	}
	public void setForm(Boolean form) {
		this.form = form;
	}
	
	public List<User> getUsers() {
		return Users;
	}
	public void setUsers(List<User> users) {
		Users = users;
	}
	public User getUser() {
		return User;
	}
	public void setUser(User user) {
		User = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public List<User> getUsersFiltred() {
		return UsersFiltred;
	}
	public void setUsersFiltred(List<User> usersFiltred) {
		UsersFiltred = usersFiltred;
	}
	
	
	@PostConstruct
	public void init(){
		form=true;
		Users=local.findAllUsers();
	}
	
	public String doUpdate(){
		local.updateUser(User);
		return null;
	}
	
	
	public String doDeleteUser(User Order){
		local.deleteUser(Order);
		init();
		return null;
	}
	
	public String initialiser(){
		
		User =new User();
		return null;
	}


	
	
	

}

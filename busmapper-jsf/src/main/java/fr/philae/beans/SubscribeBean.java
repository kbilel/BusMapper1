package fr.philae.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import fr.philae.busmapper.domain.Stops;
import fr.philae.busmapper.domain.User;
import fr.philae.busmapper.services.gestion.stop.StopServicesLocal;
import fr.philae.busmapper.services.gestion.user.UserServicesLocal;

@ManagedBean
@ViewScoped
public class SubscribeBean implements Serializable {
	private static final long serialVersionUID = 71207265440168749L;
	@EJB
	private UserServicesLocal userServicesLocal;
	@EJB
	private StopServicesLocal stopServicesLocal;
	private String fullname;
	private String email ;
	private String login;
	private String password;
	private String repassword;
	private String navigateTo;
	private String citieIncrement;
	private String gender;
	private Integer age;
	private String userType;
	private String keyword;
	private String phoneNumber;
	
	private String selectedStation;
	 private List<String> selectedCities;   
	  private List<String> cities;
	

	User user1;
	User user2 = new User();
	Stops stop1;

	
	  @PostConstruct
	    public void init() {
	        cities = new ArrayList<String>();
	        cities.add("Châtelet");
	        cities.add("Pont-Neuf- Quai du Louvre");
	        cities.add("Pont-Neuf- Quai des Grands Augustins");
	        cities.add("Mazarine");
	        cities.add("Saint-Germain");
			cities.add("Sénat");
			cities.add("Musée du Luxembourg");
			cities.add("Guynemer");
			cities.add("Bréa");
			cities.add("Vavin");
			cities.add("Place du 18 juin 1940");
			cities.add("Rue du Départ");
			cities.add("Gare Montparnasse");
			cities.add("Gaîté");
			cities.add("Losserand");
			cities.add("Château");
			cities.add("Rue Bénard");
			cities.add("Alésia");
			cities.add("Hôpitaux Notre-Dame-de-Bon-Secours");
			cities.add("Jean Moulin");
			cities.add("Porte de Châtillon");
			cities.add("Porte Didot");
			cities.add("Porte de Vanves");
			cities.add("Pont de la Vallée");
			cities.add("Jean Jaurès");
			cities.add("Carrefour Albert Legris");
			cities.add("Vanves");
	        System.out.println("genderis"+gender);
	    }
	  
	public String doSubscribe() {
		 System.out.println("genderis"+gender);
		
		
	
	 
		System.out.println("item selected are "+selectedCities);
		user1 = new User();
user1.setEmail(email);
user1.setFullName(fullname);
user1.setUserName(login);
user1.setAge(age);
user1.setPassword(password);
user1.setGender(gender);
user1.setUserType(userType);
user1.setPhoneNumber(phoneNumber);
System.out.println(gender);
//	citieIncrement=selectedCities.get(0);
	

user1.setStationFollow(selectedStation);

		//stopServicesLocal.addStop(stop1);
		//userServicesLocal.addUser(user1);

		if (userServicesLocal.addUser(user1)) {
			
			
			System.out.println("OK loto user registred");
			navigateTo="/loginboot?faces-redirect=true";
			 System.out.println("genderis"+gender);
			return navigateTo;
		} else
		{
			System.out.println("Erreur ...add registration user");
			 System.out.println("genderis"+gender);
			
		return navigateTo;
		
		}
		 
	
	}
	
	

	

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

	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	public  List<String>getSelectedCities() {
		return selectedCities;
	}

	public void setSelectedCities( List<String>selectedCities) {
		this.selectedCities = selectedCities;
	}
	public String getCitieIncrement() {
		return citieIncrement;
	}
	public void setCitieIncrement(String citieIncrement) {
		this.citieIncrement = citieIncrement;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	 public String getKeyword() {
	        return keyword;
	    }
	 
	    public void setKeyword(String keyword) {
	        this.keyword = keyword;
	    }
	     
	    public void search() {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"No results found with ", "'" + keyword + "'"));
	    }

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public String getUserType() {
			return userType;
		}

		public void setUserType(String userType) {
			this.userType = userType;
		}

		public String getSelectedStation() {
			return selectedStation;
		}

		public void setSelectedStation(String selectedStation) {
			this.selectedStation = selectedStation;
		}

		public String getRepassword() {
			return repassword;
		}

		public void setRepassword(String repassword) {
			this.repassword = repassword;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

}

package fr.philae.beans;
 

 
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

import fr.philae.busmapper.domain.User;
import fr.philae.busmapper.services.gestion.user.UserServicesLocal;
 
@ManagedBean
@ApplicationScoped

public class ButtonView {

	@EJB
	UserServicesLocal local;
	private String lat;
	private String lon;
	private String nextStop;
	private String countTime;
	private Integer numberOfUserNextStation;
	
	public String getCountTime() {
		return countTime;
	}

	public void setCountTime(String countTime) {
		this.countTime = countTime;
	}

	private List<User> usersInActualStation= new ArrayList<>();
	 private int number;
	 
	 private Boolean pollRender=true;
	 private Boolean userConnectedInUsersInActualStation=false;
	
	 
	 
	
	    public int getNumber() {
	        return number;
	    }
	 
	    public void increment() {
	    	System.out.println("debut increment");
	        number++;
	    }
	
	


//	public void submit() {
//	    System.out.println("x: " + lat);
//	    System.out.println("y: " + lon);
//	    
//	    
//	}
	public void printme(){
		   System.out.println("sysout de x: " + lat);
		    System.out.println("sysout de y: " + lon);
		    System.out.println("prochaine station : "+nextStop);
		 
	}
	
	public void printi(){
		
	
		System.out.println("this is the hidden value : "+lat);
		System.out.println("this is the hidden value : "+lon);
		   System.out.println("prochaine station : "+nextStop);
		   System.out.println("temps rest : ant "+countTime);
		   numberOfUserNextStation=local.findNumberUserByStation("Pont-Neuf- Quai du Louvre");
		   System.out.println("number user in next station is :"+local.findNumberUserByStation("Pont-Neuf- Quai du Louvre")+nextStop);
		   
		   usersInActualStation=local.findUsersByStation(nextStop);
		   
		   for (User user : usersInActualStation) {
			if(user.getUserName().toString().equals(LoginBean.getUserOnline().getUserName()))
			{
				userConnectedInUsersInActualStation=true;
				
				System.out.println("tori exist ");
				break;
				
			}
		
//			else
//			{
//				userConnectedInUsersInActualStation=false;
//			break;
//			
//			}
		   }
		   
		   System.out.println("toriend "+userConnectedInUsersInActualStation);
		  
	}
	
	
	
	public Boolean UserExistInUsersByStation()
	{        
		return userConnectedInUsersInActualStation;
	}
	
	
		
	

	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getNextStop() {
		return nextStop;
	}

	public void setNextStop(String nextStop) {
		this.nextStop = nextStop;
	}

	public Boolean getUserConnectedInUsersInActualStation() {
		return userConnectedInUsersInActualStation;
	}

	public void setUserConnectedInUsersInActualStation(
			Boolean userConnectedInUsersInActualStation) {
		this.userConnectedInUsersInActualStation = userConnectedInUsersInActualStation;
	}

	public Boolean getPollRender() {
		return pollRender;
	}

	public void setPollRender(Boolean pollRender) {
		this.pollRender = pollRender;
	}

	public Integer getNumberOfUserNextStation() {
		return numberOfUserNextStation;
	}

	public void setNumberOfUserNextStation(Integer numberOfUserNextStation) {
		this.numberOfUserNextStation = numberOfUserNextStation;
	}


    
     
   



	
}
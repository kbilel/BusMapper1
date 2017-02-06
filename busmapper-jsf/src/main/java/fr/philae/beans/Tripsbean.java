package fr.philae.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;









import fr.philae.busmapper.domain.Feed;
import fr.philae.busmapper.domain.Stops;
import fr.philae.busmapper.domain.Trips;
import fr.philae.busmapper.domain.Tripstop;
import fr.philae.busmapper.domain.User;
import fr.philae.busmapper.services.gestion.feed.FeedServicesLocal;
import fr.philae.busmapper.services.gestion.stop.StopServicesLocal;
import fr.philae.busmapper.services.gestion.trip.TripServicesLocal;

@ManagedBean
@RequestScoped
public class Tripsbean implements Serializable{

	private static final long serialVersionUID = 1L;
	@EJB
	private FeedServicesLocal feedservicesLocal;
	@EJB 
	private StopServicesLocal stopServicesLocal;
	
	@EJB 
	private TripServicesLocal tripServicesLocal;
	
	private String  feedString="10020361081078366";
	
	private final Logger log = Logger.getLogger(getClass().getName());
	private List<Feed> feeds =new ArrayList<Feed>();
	private List<Tripstop> trips =new ArrayList<Tripstop>();
	private List<Stops> stops =new ArrayList<Stops>();
	private String tripSelect;
private Feed feed1=new Feed();

private List<String> myFeeds;
private List<Tripstop> trips2;
private Set<String> uniqueMyFeeds;
	  
	    
	
	@PostConstruct
	public void init(){
		
		System.out.println("mxis"+feedString);
		//getAlltrips
		trips=tripServicesLocal.findAllTripStopByIdTrip(feedString);
		trips2=tripServicesLocal.findAllTripStop();
	
		myFeeds= new ArrayList<String>();
		for (Tripstop tripstop : trips2) {
			
			myFeeds.add(tripstop.getAbtripID());
			System.out.println("hora"+myFeeds);
		}
		 uniqueMyFeeds = new HashSet<String>(myFeeds);

		
		  setStops(stopServicesLocal.findAllStops());
	}
	
	
	    public void increment() {
	       System.out.println("gere"+tripSelect);
	    }
	
	
	// à ne pas utiliser pour le moment 
	public String findme(Tripstop trip){
		return stopServicesLocal.findStopById(trip.getId()).getStopAName();
		
		
	}
	

	
	//return station name to fedd column station 
	public String findStationNameById(Integer stopId){
		System.out.println("mytest"+tripServicesLocal.findAllTripStopByIdTrip("21"));
		System.out.println("onem"+tripSelect);
	
		return  stopServicesLocal.findStopById(stopId).getStopAName();
		
	}

  
public void  updateTrip(){
	System.out.println("entrer update");
	trips=tripServicesLocal.findAllTripStopByIdTrip(feedString);
	log.warning(("sortie update avec logger  " + feedString));
	System.out.println("sortie update"+feedString);
}

	


	public String getFeedString() {
		return feedString;
	}


	public void setFeedString(String feedString) {
		this.feedString = feedString;
	}


	public List<Feed> getFeeds() {
		return feeds;
	}


	public void setFeeds(List<Feed> feeds) {
		this.feeds = feeds;
	}
	

	public List<Tripstop> getTrips() {
		return trips;
	}

	public void setTrips(List<Tripstop> trips) {
		this.trips = trips;
	}

	public List<Stops> getStops() {
		return stops;
	}

	public void setStops(List<Stops> stops) {
		this.stops = stops;
	}

	public String getTripSelect() {
		return tripSelect;
	}

	public void setTripSelect(String tripSelect) {
		this.tripSelect = tripSelect;
	}


	public Feed getFeed1() {
		return feed1;
	}


	public void setFeed1(Feed feed1) {
		this.feed1 = feed1;
	}


	public List<String> getMyFeeds() {
		return myFeeds;
	}


	public void setMyFeeds(List<String> myFeeds) {
		this.myFeeds = myFeeds;
	}


	public List<Tripstop> getTrips2() {
		return trips2;
	}


	public void setTrips2(List<Tripstop> trips2) {
		this.trips2 = trips2;
	}


	public Set<String> getUniqueMyFeeds() {
		return uniqueMyFeeds;
	}


	public void setUniqueMyFeeds(Set<String> uniqueMyFeeds) {
		this.uniqueMyFeeds = uniqueMyFeeds;
	}
	
	
}

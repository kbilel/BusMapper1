package fr.philae.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import com.twilio.sdk.TwilioClient;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;

import fr.philae.busmapper.domain.Feed;
import fr.philae.busmapper.domain.User;
import fr.philae.busmapper.services.gestion.feed.FeedServicesLocal;
import fr.philae.busmapper.services.gestion.user.UserServicesLocal;

@ManagedBean
@ViewScoped
public class Feedsbean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private FeedServicesLocal feedServicesLocal;

	@EJB
	private UserServicesLocal userServicesLocal;
	
	
	//TWILIO PARAMS 
	public static final String ACCOUNT_SID = "AC9366318e54b432c1b059d6130066b861"; 
	 public static final String AUTH_TOKEN = "038d8740e20b9df360eb6494f858c29f"; 
	// star notf fb
	private ArrayList<String> listunotif = new ArrayList<String>();

	private User userToupdate = new User();
	private String stationSelected;
	private String feedByStationStr;
	private List<String> mycities;
	private List<User> usersByStation;
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	private Integer numberOfNotification=0;

	






	// end otif fb
	private String feedString;

	private Feed feed1;
	private List<Feed> feeds = new ArrayList<Feed>();

	private String dateClock = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
			.format(new Date());

	



	@PostConstruct
	public void init() {
		mycities = new ArrayList<String>();
		mycities.add("Châtelet");
		mycities.add("Pont-Neuf- Quai du Louvre");
		mycities.add("Pont-Neuf- Quai des Grands Augustins");
		mycities.add("Mazarine");
		mycities.add("Saint-Germain");
		mycities.add("Sénat");
		mycities.add("Musée du Luxembourg");
		mycities.add("Guynemer");
		mycities.add("Bréa");
		mycities.add("Vavin");
		mycities.add("Place du 18 juin 1940");
		mycities.add("Rue du Départ");
		mycities.add("Gare Montparnasse");
		mycities.add("Gaîté");
		mycities.add("Losserand");
		mycities.add("Château");
		mycities.add("Rue Bénard");
		mycities.add("Alésia");
		mycities.add("Hôpitaux Notre-Dame-de-Bon-Secours");
		mycities.add("Jean Moulin");
		mycities.add("Porte de Châtillon");
		mycities.add("Porte Didot");
		mycities.add("Porte de Vanves");
		mycities.add("Pont de la Vallée");
		mycities.add("Jean Jaurès");
		mycities.add("Carrefour Albert Legris");
		mycities.add("Vanves");
		System.out.println("cities generated");

		feeds = feedServicesLocal.findAllFeeds();
		numberOfNotification=userServicesLocal.CalculateNumberNotif(loginBean.whoAmI());

	}
	
	@PreDestroy
	public void cleanUp() throws Exception {
	  listunotif=null;
	}
	
	
	
	
	

	public String feedme() {

		feed1 = new Feed();
		feed1.setNotification(feedString);
		feed1.setDateNotif(dateClock);
		System.out
				.println("contenue feeds " + feedServicesLocal.findAllFeeds());
		System.out.println("les fedds" + feeds);
		feedServicesLocal.addFeed(feed1);

		feed1.setNotification(feedString);
		// not as fb

		return "mapsDashboardAdmin?faces-redirect=true";
	}
	
	
	
	
	
	
	
	
	//FEED By STATION
	public String feedByStation() {
		usersByStation=userServicesLocal.findUsersByStation(stationSelected);
		listunotif.add(feedByStationStr);
		for (User user : usersByStation) {
			if(user.getListNotif()!=null)
			{	
				listunotif.addAll(user.getListNotif());
				
				
		
			}
			
			user.setListNotif(listunotif);
			userServicesLocal.updateUser(user);
			
		}
		
		return "mapsDashboardAdmin?faces-redirect=true";
	}
	
	
	//SEND SMS 
	public String SendSms() throws TwilioRestException{
		usersByStation=userServicesLocal.findUsersByStation(stationSelected);
		
				System.out.println("hira number from the firs user in the list "+usersByStation.get(0).getPhoneNumber().toString());
				TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN); 
				 
				 // Build the parameters 
				 List<NameValuePair> params = new ArrayList<NameValuePair>(); 
				 params.add(new BasicNameValuePair("To", usersByStation.get(0).getPhoneNumber().toString())); 
				 params.add(new BasicNameValuePair("From", "+33644607608")); 
				 params.add(new BasicNameValuePair("Body", "Be ready to catch your bus , next station vanves , time to arrive : 7 minutes"));   
			 
				 MessageFactory messageFactory = client.getAccount().getMessageFactory(); 
				 Message message = messageFactory.create(params); 
				 System.out.println("houl"); 
		
		return "mapsDashboardAdmin?faces-redirect=true";
	}

	
	
	
	
	
	
	
	public String deleteFeed(Feed feed) {

		feedServicesLocal.deleteFeed(feed);
		init();

		return "mapsDashboardAdmin?faces-redirect=true";
	}
	  public void info() {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
	    }
	public Feed getFeed1() {
		return feed1;
	}

	public void setFeed1(Feed feed1) {
		this.feed1 = feed1;
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

	public String getDateClock() {
		return dateClock;
	}

	public void setDateClock(String dateClock) {
		this.dateClock = dateClock;
	}

	public User getUserToupdate() {
		return userToupdate;
	}

	public void setUserToupdate(User userToupdate) {
		this.userToupdate = userToupdate;
	}

	public String getStationSelected() {
		return stationSelected;
	}

	public void setStationSelected(String stationSelected) {
		this.stationSelected = stationSelected;
	}

	public List<String> getMycities() {
		return mycities;
	}

	public void setMycities(List<String> mycities) {
		this.mycities = mycities;
	}

	public ArrayList<String> getListunotif() {
		return listunotif;
	}

	public void setListunotif(ArrayList<String> listunotif) {
		this.listunotif = listunotif;
	}

	public String getFeedByStationStr() {
		return feedByStationStr;
	}

	public void setFeedByStationStr(String feedByStationStr) {
		this.feedByStationStr = feedByStationStr;
	}






	public List<User> getUsersByStation() {
		return usersByStation;
	}






	public void setUsersByStation(List<User> usersByStation) {
		this.usersByStation = usersByStation;
	}
	public LoginBean getLoginBean() {
		return loginBean;
	}






	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}






	public Integer getNumberOfNotification() {
		return numberOfNotification;
	}






	public void setNumberOfNotification(Integer numberOfNotification) {
		this.numberOfNotification = numberOfNotification;
	}
}

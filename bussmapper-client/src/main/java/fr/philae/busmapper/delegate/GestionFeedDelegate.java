package fr.philae.busmapper.delegate;



import java.util.List;

import fr.philae.busmapper.domain.Feed;
import fr.philae.busmapper.locator.ServiceLocator;
import fr.philae.busmapper.services.gestion.feed.FeedServicesRemote;

public class GestionFeedDelegate {

	static FeedServicesRemote remote;
	private static final String jndi="busmapper-ejb/FeedServices!fr.philae.busmapper.services.gestion.feed.FeedServicesRemote"; 

	private static FeedServicesRemote getProxy(){
		return (FeedServicesRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	
	public  static Boolean doAddFeed(Feed feed){
	return getProxy().addFeed(feed);
	
}
	
	public  static Boolean doUpdateFeed(Feed feed){
		return getProxy().updateFeed(feed);
		
	}
	
	public  static Boolean doDeleteFeed(Feed feed){
		return getProxy().deleteFeed(feed);
		
	}
	
	public  static Feed doFindFeedById(Integer idFeed)
	{
		return getProxy().findFeedById(idFeed);
	}
	public  static List<Feed> doFindAllFeeds()
	{
		return getProxy().findAllFeeds();
	}
	
	
	
	
}

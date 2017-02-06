package fr.philae.busmapper.services.gestion.feed;

import java.util.List;

import javax.ejb.Local;

import fr.philae.busmapper.domain.Feed;

@Local
public interface FeedServicesLocal {
	Boolean addFeed(Feed feed );
	Boolean updateFeed(Feed feed);
	Boolean deleteFeed(Feed feed);
	Feed findFeedById(Integer id);
	
	List<Feed>findAllFeeds();
}

package fr.philae.busmapper.services.gestion.feed;

import java.util.List;

import javax.ejb.Remote;

import fr.philae.busmapper.domain.Feed;


@Remote
public interface FeedServicesRemote {
	Boolean addFeed(Feed feed );
	Boolean updateFeed(Feed feed);
	Boolean deleteFeed(Feed feed);
	Feed findFeedById(Integer idStop);
	
	List<Feed>findAllFeeds();
}

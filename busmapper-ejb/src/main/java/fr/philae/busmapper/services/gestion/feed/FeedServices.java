package fr.philae.busmapper.services.gestion.feed;

import java.text.MessageFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.philae.busmapper.domain.Feed;
import fr.philae.busmapper.domain.Stops;


/**
 * Session Bean implementation class FeedServices
 */
@Stateless
@LocalBean
public class FeedServices implements FeedServicesRemote, FeedServicesLocal {

	@PersistenceContext(unitName="busmapper-ejb")
	EntityManager entityManager;
	
	
    public FeedServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addFeed(Feed feed) {
		try {
			
		
			entityManager.persist(feed);
			System.out.println("ok ejb");
			
			return true;
		} catch (Exception e) {
			System.out.println("erreur ejb");
			return false;
			
		}
		
	}

	@Override
	public Boolean updateFeed(Feed feed) {
		try {
			entityManager.merge(feed);
			
			return true;
		} catch (Exception e) {
			System.out.println("exception update user");
			return false;
		}
	}

	@Override
	public Boolean deleteFeed(Feed feed) {
try {
			
			
			entityManager.remove(entityManager.merge(feed));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Feed findFeedById(Integer id) {
		Feed feed=null;
		try {
			feed=entityManager.find(Feed.class, id);
		
		} catch (Exception e) {
			
		}
		return feed;
	}

	@Override
	public List<Feed> findAllFeeds() {
		Query query=entityManager.createQuery("select s from Feed s ");
		return query.getResultList();
	}
	

}

package fr.philae.busmapper.services.gestion.stop;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



import fr.philae.busmapper.domain.Stops;

/**
 * Session Bean implementation class StopServices
 */
@Stateless
@LocalBean
public class StopServices implements StopServicesRemote, StopServicesLocal {
	
	@PersistenceContext(unitName="busmapper-ejb")
	EntityManager entityManager;
	
    public StopServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addStop(Stops stop) {
		
		
		try {
			entityManager.persist(stop);
			System.out.println("ok ejb");
			
			return true;
		} catch (Exception e) {
			System.out.println("erreur ejb");
			return false;
			
		}
	}

	@Override
	public Boolean updateStop(Stops stop) {
		try {
			entityManager.merge(stop);
			
			return true;
		} catch (Exception e) {
			System.out.println("exception update user");
			return false;
		}
	}

	@Override
	public Boolean deleteStop(Stops stop) {
try {
			
			
			entityManager.remove(entityManager.merge(stop));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Stops findStopById(Integer id) {
		Stops stop=null;
		try {
			stop=entityManager.find(Stops.class, id);
		
		} catch (Exception e) {
			
		}
		return stop;
	}

	@Override
	public List<Stops> findAllStops() {
		Query query=entityManager.createQuery("select s from Stops s ");
		return query.getResultList();
	}

}

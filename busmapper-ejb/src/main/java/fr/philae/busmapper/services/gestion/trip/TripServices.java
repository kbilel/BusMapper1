package fr.philae.busmapper.services.gestion.trip;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.philae.busmapper.domain.Tripstop;
import fr.philae.busmapper.domain.User;

/**
 * Session Bean implementation class TripServices
 */
@Stateless
@LocalBean
public class TripServices implements TripServicesRemote, TripServicesLocal {

	
	@PersistenceContext(unitName="busmapper-ejb")
	EntityManager entityManager;
    public TripServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addTrip(Tripstop tripstop) {
		try {
			entityManager.persist(tripstop);
			System.out.println("ok ejb");
			
			return true;
		} catch (Exception e) {
			System.out.println("erreur ejb");
			return false;
			
		}
	}

	@Override
	public Boolean updateTrip(Tripstop tripstop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteTrip(Tripstop tripstop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tripstop findTripById(Integer id) {
		Tripstop tripstop=null;
		try {
			tripstop=entityManager.find(Tripstop.class, id);
		
		} catch (Exception e) {
			
		}
		return tripstop;
	}

	@Override
	public List<Tripstop> findAllTripStop() {
		Query query=entityManager.createQuery("select u from Tripstop u ");
		return query.getResultList();
	}
	@Override
	public List<Tripstop> findAllTripStopByIdTrip(String abtripID) {
		List<Tripstop> tripstops =null;
		
		Query query=entityManager.createQuery("select u from Tripstop u where u.abtripID=:p ");
		query.setParameter("p", abtripID);
		if (query.getResultList()!=null)
		{
			tripstops= query.getResultList();
			
		
		System.out.println("ejb find  auction stationFollow is not nullnumber is "+tripstops);
		
		return tripstops;
		}
		else {
		
			return tripstops;
		}
	}

}

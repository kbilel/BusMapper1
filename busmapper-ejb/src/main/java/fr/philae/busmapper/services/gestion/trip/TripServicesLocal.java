package fr.philae.busmapper.services.gestion.trip;

import java.util.List;

import javax.ejb.Local;

import fr.philae.busmapper.domain.Tripstop;

@Local
public interface TripServicesLocal {
	Boolean addTrip(Tripstop tripstop );
	Boolean updateTrip(Tripstop tripstop);
	Boolean deleteTrip(Tripstop tripstop);
	Tripstop findTripById(Integer id);
	
	List<Tripstop>findAllTripStop();
	List<Tripstop> findAllTripStopByIdTrip(String abtripID) ;
}

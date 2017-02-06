package fr.philae.busmapper.services.gestion.stop;

import java.util.List;

import javax.ejb.Remote;

import fr.philae.busmapper.domain.Stops;

@Remote
public interface StopServicesRemote {
	
	Boolean addStop(Stops stop );
	Boolean updateStop(Stops stop);
	Boolean deleteStop(Stops stop);
	Stops findStopById(Integer id);
	
	List<Stops>findAllStops();

}

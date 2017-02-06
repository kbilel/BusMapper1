package fr.philae.busmapper.services.gestion.stop;

import java.util.List;

import javax.ejb.Local;

import fr.philae.busmapper.domain.Stops;

@Local
public interface StopServicesLocal {
	Boolean addStop(Stops stop );
	Boolean updateStop(Stops stop);
	Boolean deleteStop(Stops stop);
	Stops findStopById(Integer id);
	
	List<Stops>findAllStops();

}

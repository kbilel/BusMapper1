package fr.philae.busmapper.delegate;



import java.util.List;

import fr.philae.busmapper.domain.Stops;

import fr.philae.busmapper.locator.ServiceLocator;
import fr.philae.busmapper.services.gestion.stop.StopServicesRemote;


public class GestionStopDelegate {

	static StopServicesRemote remote;
	private static final String jndi="busmapper-ejb/StopServices!fr.philae.busmapper.services.gestion.stop.StopServicesRemote"; 

	private static StopServicesRemote getProxy(){
		return (StopServicesRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	
	public  static Boolean doAddStop(Stops stop){
	return getProxy().addStop(stop);
	
}
	
	public  static Boolean doUpdateStops(Stops stop){
		return getProxy().updateStop(stop);
		
	}
	
	public  static Boolean doDeleteStops(Stops stop){
		return getProxy().deleteStop(stop);
		
	}
	
	public  static Stops doFindStopsById(Integer idStops)
	{
		return getProxy().findStopById(idStops);
	}
	public  static List<Stops> doFindAllStops()
	{
		return getProxy().findAllStops();
	}
	

	
}

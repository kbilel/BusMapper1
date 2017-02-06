package fr.philae.test;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import fr.philae.busmapper.domain.Tripstop;
import fr.philae.busmapper.services.gestion.stop.StopServicesRemote;
import fr.philae.busmapper.services.gestion.trip.TripServicesRemote;












public class TestGestionTrip {
	static TripServicesRemote remote;
	static StopServicesRemote remote2;
	
	public static void doAddTrip(TripServicesRemote remote){

		Tripstop tripstop=new Tripstop();
		tripstop.setDepartureTime("15");
	
		if(remote.addTrip(tripstop)  ){
			System.out.println("OK");
	}
	else
		System.out.println("Erreur ...add");
		
	}
	public static void doUpdateUser(TripServicesRemote remote){
//
//		//Stops stop=remote.findStopById(1);
//	stop.setStopDesc("d");
//		if(remote.updateStop(stop)){
//			System.out.println("OK");
//		}
//		else
//			System.out.println("Erreur ...");

	}
	public static void doDeleteStation(TripServicesRemote remote){

//	//	Stops stop=remote.findStopById(1);
//		if (stop ==null)
//System.out.println("stop null");
//		if(remote.deleteStop(stop)){
//			System.out.println("OK");
//		}
//		else
//			System.out.println("Erreur ...delete");

	}

	
	public static void doFindAllStops(TripServicesRemote remote){
		List<Tripstop> tripstops=remote.findAllTripStop();
		//Configuration configuration=new Configuration();

		if(tripstops!=null){
			System.out.println("OK find"+tripstops.toString());
		}
		else
			System.out.println("Erreur ...find Config");

	}

	
	public static void main(String[] args) {
		
		
		try {
			Context context=new InitialContext();
			remote=(TripServicesRemote) context.lookup("busmapper-ejb/TripServices!fr.philae.busmapper.services.gestion.trip.TripServicesRemote");
			remote2=(StopServicesRemote) context.lookup("busmapper-ejb/StopServices!fr.philae.busmapper.services.gestion.stop.StopServicesRemote");
		
		System.out.println("isis"+remote.findTripById(5).getArrivaTime()+"and the stop name is "+remote2.findStopById(remote.findTripById(5).getStopId()).getStopAName());
		System.out.println("mytest"+remote.findAllTripStopByIdTrip("21"));
				} catch (NamingException e) {
		System.out.println("erreur jndi ... ");
			e.printStackTrace();
		}
	//doAddTrip(remote);
	//dofindParticipateOrNot(remote);
		doFindAllStops(remote);
	//doUpdateUser(remote);
	//doDeleteUser(remote);
	//doAuthentifUser(remote);
	}
}

package fr.philae.test;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import fr.philae.busmapper.domain.Feed;
import fr.philae.busmapper.domain.Stops;
import fr.philae.busmapper.domain.User;
import fr.philae.busmapper.services.gestion.stop.StopServicesRemote;












public class TestGestionStop {
	static StopServicesRemote remote;
	
	public static void doAddStop(StopServicesRemote remote){

		Stops stop=new Stops();
		stop.setStopAName("fk");
	
		if(remote.addStop(stop)  ){
			System.out.println("OK");
	}
	else
		System.out.println("Erreur ...add");
		
	}
	public static void doUpdateUser(StopServicesRemote remote){

		Stops stop=remote.findStopById(1);
	stop.setStopDesc("d");
		if(remote.updateStop(stop)){
			System.out.println("OK");
		}
		else
			System.out.println("Erreur ...");

	}
	public static void doDeleteStation(StopServicesRemote remote){

		Stops stop=remote.findStopById(1);
		if (stop ==null)
System.out.println("stop null");
		if(remote.deleteStop(stop)){
			System.out.println("OK");
		}
		else
			System.out.println("Erreur ...delete");

	}

	
	public static void doFindAllStops(StopServicesRemote remote){
		List<Stops> stops=remote.findAllStops();
		//Configuration configuration=new Configuration();

		if(stops!=null){
			System.out.println("OK find"+stops);
		}
		else
			System.out.println("Erreur ...find Config");

	}

	
	public static void main(String[] args) {
		
		
		try {
			Context context=new InitialContext();
			remote=(StopServicesRemote) context.lookup("busmapper-ejb/StopServices!fr.philae.busmapper.services.gestion.stop.StopServicesRemote");
			Stops stop6=remote.findStopById(3442424)   ;
			System.out.println("his"+stop6.getStopAName());
			
				} catch (NamingException e) {
		System.out.println("erreur jndi ... ");
			e.printStackTrace();
		}
	//doAddStop(remote);	
	//dofindParticipateOrNot(remote);
		//doFindAllStops(remote);
	//doUpdateUser(remote);
	//doDeleteUser(remote);
	//doAuthentifUser(remote);
	}
}

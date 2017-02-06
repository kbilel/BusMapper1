package fr.philae.test;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import fr.philae.busmapper.domain.User;
import fr.philae.busmapper.services.gestion.user.UserServicesRemote;










public class TestGestionUser {
	static UserServicesRemote remote;
	public static void doAddUser(UserServicesRemote remote){

		User user=new User();
		user.setUserName("bilo");
		user.setAdress("aa");
		user.setEmail("achrddef");
		user.setFullName("achref");
		user.setPassword("bilel");
		

		
//		if(remote.addUser(user) && remote.addUser(user1) && remote.addUser(user2) && remote.addUser(user3) ){
//			System.out.println("OK");
			if(remote.addUser(user)  ){
				System.out.println("OK");
		}
		else
			System.out.println("Erreur ...add");
		
	}
	public static void doUpdateUser(UserServicesRemote remote){

		User user=remote.findUserById(1);
		user.setUserName("bb");
		user.setFullName("bb");
		user.setGender("inactif");
		if(remote.updateUser(user)){
			System.out.println("OK");
		}
		else
			System.out.println("Erreur ...");

	}
	public static void doDeleteUser(UserServicesRemote remote){

		User user=remote.findUserById(1);
		if (user ==null)
System.out.println("user null");
		if(remote.deleteUser(user)){
			System.out.println("OK");
		}
		else
			System.out.println("Erreur ...delete");

	}
	
	public static void doAuthentifUser(UserServicesRemote remote){

User user= remote.authentificate("bilel", "bilel");
		
		
			
		
	if(user!=null)
	{
		System.out.println("OK authentification");
		
	}
	else
		System.out.println("ouupssss erreur authentification");

	}
	
	
	public static void doFindAllUser(UserServicesRemote remote){
		List<User> users=remote.findAllUsers();
		//Configuration configuration=new Configuration();

		if(users!=null){
			System.out.println("OK find"+users);
		}
		else
			System.out.println("Erreur ...find Config");

	}
	
	//calculate notifNumber
	public static void doCalculateNotif(UserServicesRemote remote){

		User user=remote.findUserById(1);
		
		if(remote.CalculateNumberNotif(user)>0){
			System.out.println("OK number is "+user.getListNotif().toString()+remote.CalculateNumberNotif(user));
		}
		else
			System.out.println("Erreur ...");

	}
	//find by STATION
	
	public static void doFindAllUserByStation(UserServicesRemote remote){
		List<User> users=remote.findUsersByStation("Rome");
		//Configuration configuration=new Configuration();

		if(users!=null){
			System.out.println("OK find"+users);
		}
		else
			System.out.println("Erreur ...find Config");

	}
	public static void dofindParticipateOrNot(UserServicesRemote remote){
		List<User> users=remote.findParticipateOrNot("Rome");
		//Integer numberoffalse= remote.findParticipateOrNot("a");
		
		if (users!=null)
			System.out.println("liste non  bull"+users);
		else
			System.out.println("entrer else liste null");
	}
	
	
	public static void doFindNumberuserByStation(UserServicesRemote remote){
		Integer users=remote.findNumberUserByStation("London");
		//Configuration configuration=new Configuration();

		if(users!=null){
			System.out.println("OK find number is"+users);
		}
		else
			System.out.println("Erreur ...find Config");

	}
	
	public static void doFindNumberuserByGender(UserServicesRemote remote){
		Integer users=remote.findNumberUserByGender("Female");
		//Configuration configuration=new Configuration();

		if(users!=null){
			System.out.println("OK find number is"+users);
		}
		else
			System.out.println("Erreur ...find Config");

	}
	
	public static void doFindNumberuserByAge(UserServicesRemote remote){
		Integer users=remote.findNumberUserByAge(18);
		//Configuration configuration=new Configuration();

		if(users!=null){
			System.out.println("OK find number is"+users);
		}
		else
			System.out.println("Erreur ...find Config");

	}
	
	
	public static void doFindNumberuserByUserType(UserServicesRemote remote){
		Integer users=remote.findNumberUserByUserType("student");
		//Configuration configuration=new Configuration();

		if(users!=null){
			System.out.println("OK find number is"+users);
		}
		else
			System.out.println("Erreur ...find Config");

	}
	
	
	
	
	
	public static void main(String[] args) {
		
		
		try {
			Context context=new InitialContext();
			remote=(UserServicesRemote) context.lookup("busmapper-ejb/UserServices!fr.philae.busmapper.services.gestion.user.UserServicesRemote");
				} catch (NamingException e) {
		System.out.println("erreur jndi ... ");
			e.printStackTrace();
		}
	//doAddUser(remote);	
	//dofindParticipateOrNot(remote);
doFindAllUser(remote);
	//doFindAllUserByStation(remote);
	//doUpdateUser(remote);
	//doDeleteUser(remote);
	//doAuthentifUser(remote);
	
	doCalculateNotif(remote);
	//doFindNumberuserByStation(remote);
	//doFindNumberuserByGender(remote);
	//doFindNumberuserByAge(remote);
	//doFindNumberuserByUserType(remote);
	}
}

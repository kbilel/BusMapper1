package fr.philae.busmapper.delegate;



import java.util.List;

import fr.philae.busmapper.domain.User;
import fr.philae.busmapper.locator.ServiceLocator;
import fr.philae.busmapper.services.gestion.user.UserServicesRemote;

public class GestionUserDelegate {

	static UserServicesRemote remote;
	private static final String jndi="busmapper-ejb/UserServices!fr.philae.busmapper.services.gestion.user.UserServicesRemote"; 

	private static UserServicesRemote getProxy(){
		return (UserServicesRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	
	public  static Boolean doAddUser(User user){
	return getProxy().addUser(user);
	
}
	
	public  static Boolean doUpdateUser(User user){
		return getProxy().updateUser(user);
		
	}
	
	public  static Boolean doDeleteUser(User user){
		return getProxy().deleteUser(user);
		
	}
	
	public  static User doFindUserById(Integer idUser)
	{
		return getProxy().findUserById(idUser);
	}
	public  static List<User> doFindAllUsers()
	{
		return getProxy().findAllUsers();
	}
	
	
	public static User doAuthentificate(String login,String pwd){
		return getProxy().authentificate(login, pwd);
	}
	public static User doFindUserByUsername(String name){
		return getProxy().findUserByUsername(name);
	}
	
	public  static List<User> dofindParticipateOrNot(String participate)
	{
		return getProxy().findParticipateOrNot(participate);
	}
	
	public  static List<User> doFindAllUserByStation(String stationFollow)
	{
		return getProxy().findUsersByStation(stationFollow);
	}
	public  static Integer doFindAllUsersBylevel(String level)
	{
		return getProxy().findUserByLevel(level);
	}
	
}

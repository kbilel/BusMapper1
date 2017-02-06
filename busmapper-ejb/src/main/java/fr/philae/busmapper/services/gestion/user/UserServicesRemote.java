package fr.philae.busmapper.services.gestion.user;

import java.util.List;

import javax.ejb.Remote;

import fr.philae.busmapper.domain.User;

@Remote
public interface UserServicesRemote {
	Boolean addUser(User user );
	Boolean updateUser(User user);
	Boolean deleteUser(User user);
	User findUserById(Integer idUser);
	User findUserByUsername(String name);
	List<User>findAllUsers();
	User authentificate(String login,String pwd);
	Boolean exist(String login);
	Boolean existEmail(String email);
	List<User> findParticipateOrNot(String participate);//return list user by gender
	
	Integer    findNumberUserByStation(String station);  //ok
	Integer    findNumberUserByGender(String gender);    //ok
	Integer    findNumberUserByAge(Integer age);          //ok
	Integer    findNumberUserByUserType(String userType); //ok
	Integer     findNumberUserByAgeRange(Integer starAge,Integer endAge);
	
	Integer     CalculateNumberNotif(User user);
	
	
	
	Integer findUserByLevel(String level);
	
	
	List<User> findUsersByStation(String station);
	
	
}

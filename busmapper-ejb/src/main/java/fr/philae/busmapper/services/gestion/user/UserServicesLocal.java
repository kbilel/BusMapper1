package fr.philae.busmapper.services.gestion.user;

import java.util.List;

import javax.ejb.Local;

import fr.philae.busmapper.domain.User;


@Local
public interface UserServicesLocal {
	Boolean addUser(User user );
	Boolean updateUser(User user);
	Boolean deleteUser(User user);
	User findUserById(Integer idUser);
	List<User>findAllUsers();
	User findUserByUsername(String name);
	User authentificate(String login,String pwd);
	Boolean exist(String login);
	Boolean existEmail(String email);
	List<User> findParticipateOrNot(String participate);//retourn elite user by gender
	
	Integer    findNumberUserByStation(String station);  //ok
	Integer    findNumberUserByGender(String gender);    //ok
	Integer    findNumberUserByAge(Integer age);           //ok
	Integer    findNumberUserByUserType(String userType); //ok
	Integer     findNumberUserByAgeRange(Integer starAge,Integer endAge);
	Integer     CalculateNumberNotif(User user);
	
	
	
	Integer findUserByLevel(String age);  //byage
	List<User> findUsersByStation(String station);

}

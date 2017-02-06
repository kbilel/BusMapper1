package fr.philae.busmapper.services.gestion.user;




import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import fr.philae.busmapper.domain.User;




/**
 * Session Bean implementation class UserServices
 */
@Stateless
public class UserServices implements UserServicesRemote, UserServicesLocal {
	@PersistenceContext(unitName="busmapper-ejb")
	EntityManager entityManager;
    public UserServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addUser(User user) {
		try {
			entityManager.persist(user);
			System.out.println("ok ejb");
			
			return true;
		} catch (Exception e) {
			System.out.println("erreur ejb");
			return false;
			
		}
		
	}

	@Override
	public Boolean updateUser(User user) {
		try {
			entityManager.merge(user);
			
			return true;
		} catch (Exception e) {
			System.out.println("exception update user");
			return false;
		}
	}

	@Override
	public Boolean deleteUser(User user) {
		try {
			
			
			entityManager.remove(entityManager.merge(user));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User findUserById(Integer idUser) {
		User user=null;
		try {
			user=entityManager.find(User.class, idUser);
		
		} catch (Exception e) {
			
		}
		return user;
	}

	@Override
	public List<User> findAllUsers() {
		Query query=entityManager.createQuery("select u from User u ");
		return query.getResultList();
	}

	@Override
	public User authentificate(String login, String pwd) {
		User user=null;

		try {
			Query query=entityManager.createQuery("select u from User u where u.userName=:l and u.password=:p");	
		query.setParameter("l", login).setParameter("p",pwd);
		user=(User) query.getSingleResult();
		} catch (Exception e) {
			user=null;
		}
		return user;
	}

	@Override
	public User findUserByUsername(String name) {
		
		User user=null;

		try {
			Query query=entityManager.createQuery("select u from User u where u.userName=:l");	
		query.setParameter("l", name);
		user=(User) query.getSingleResult();
		} catch (Exception e) {
			user=null;
		}
		return user;
	}
	@Override
	public List<User> findParticipateOrNot(String participate) {
		List<User> users =null;
		Integer number;
		Query query=entityManager.createQuery("select u from User u where u.participation=:p ");
		query.setParameter("p", participate);
		if (query.getResultList()!=null)
		{
			users= query.getResultList();
			number=users.size();
		
		System.out.println("ejb find  auction participate is not nullnumber is "+number);
		
		return users;
		}
		else {
			number=0;
			return users;
		}
			
	}
	
	@Override
	public List<User> findUsersByStation(String stationFollow) {
		List<User> users =null;
		Integer number;
		Query query=entityManager.createQuery("select u from User u where u.stationFollow=:p ");
		query.setParameter("p", stationFollow);
		if (query.getResultList()!=null)
		{
			users= query.getResultList();
			number=users.size();
		
		System.out.println("ejb find  auction stationFollow is not nullnumber is "+number);
		
		return users;
		}
		else {
			number=0;
			return users;
		}
		
		
	}
	
	@Override
	public Integer findUserByLevel(String level) {
		List<User> users =null;
		Integer number;
		Query query=entityManager.createQuery("select u from User u where u.level=:p ");
		query.setParameter("p", level);
		if (query.getResultList()!=null)
		System.out.println("ejb find  level is not null");
		users= query.getResultList();
		number=users.size();
		return number;
	}

	@Override
	public Integer findNumberUserByStation(String station) {
		List<User> users =null;
		Integer number;
		Query query=entityManager.createQuery("select u from User u where u.stationFollow=:p ");
		query.setParameter("p", station);
		if (query.getResultList()!=null)
		{
			users= query.getResultList();
			number=users.size();
		
		System.out.println("ejb find   stationFollow is not nullnumber is "+number);
		
		return number;
		}
		else {
			number=0;
			return number;
		}
		
	}

	@Override
	public Integer findNumberUserByGender(String gender) {
		List<User> users =null;
		Integer number;
		Query query=entityManager.createQuery("select u from User u where u.gender=:p ");
		query.setParameter("p", gender);
		if (query.getResultList()!=null)
		{
			users= query.getResultList();
			number=users.size();
		
		System.out.println("ejb find   gender is not null number is "+number);
		
		return number;
		}
		else {
			number=0;
			return number;
		}
	}

	@Override
	public Integer findNumberUserByAge(Integer ageg) {
		List<User> users =null;
		Integer number;
		Query query=entityManager.createQuery("select u from User u where u.age=:p ");
		query.setParameter("p", ageg);
		if (query.getResultList()!=null)
		{
			users= query.getResultList();
			number=users.size();
		
		System.out.println("ejb find   gender is not null number is "+number);
		
		return number;
		}
		else {
			number=0;
			return number;
		}
	}

	@Override
	public Integer findNumberUserByUserType(String userType) {
		List<User> users =null;
		Integer number;
		Query query=entityManager.createQuery("select u from User u where u.userType=:p ");
		query.setParameter("p", userType);
		if (query.getResultList()!=null)
		{
			users= query.getResultList();
			number=users.size();
		
		System.out.println("ejb find   gender is not null number is "+number);
		
		return number;
		}
		else {
			number=0;
			return number;
		}
	}

	@Override
	public Integer findNumberUserByAgeRange(Integer starAge,Integer endAge) {
		List<User> usersRange1020,usersRange2030,usersRange3040,usersRange4050,usersRange5060,usersRange6070,usersRange7080 =null;
		Integer number;
		Query query=entityManager.createQuery("select u from User u where u.age >= :p and  u.age <=:q  ");
		query.setParameter("p", starAge).setParameter("q", endAge);
		if (query.getResultList()!=null)
		{
			usersRange1020= query.getResultList();
			number=usersRange1020.size();
		
		System.out.println("ejb find   user by range age found the number is "+number);
		
		return number;
		}
		else {
			number=0;
			return number;
		}
	}

	@Override
	public Integer CalculateNumberNotif(User user) {
		if(user.getListNotif()!=null)
		{
		System.out.println("start calculation number notif");
		return user.getListNotif().size();
		}
		else return 0;
	
	}

	@Override
	public Boolean exist(String login) {
		User user=null;
		Boolean itExsit=false;
		try {
			Query query=entityManager.createQuery("select u from User u where u.userName=:l ");	
		query.setParameter("l", login);
		user=(User) query.getSingleResult();
		itExsit=true;
		} catch (Exception e) {
			user=null;
		}
		return itExsit;
	}

	@Override
	public Boolean existEmail(String email) {
		User user8=null;
		Boolean emailExsit=false;
		try {
			Query query=entityManager.createQuery("select u from User u where u.email=:l ");	
		query.setParameter("l", email);
		user8=(User) query.getSingleResult();
		emailExsit=true;
		} catch (Exception e) {
			user8=null;
		}
		return emailExsit;
	}






	}
	

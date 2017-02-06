package test;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.philae.busmapper.domain.User;
import fr.philae.busmapper.services.gestion.user.UserServicesLocal;



/*
 * Session Bean implementation class InitDb
 */
@Singleton
@Startup
public class InitDb  {

	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	private UserServicesLocal userLocal;

	
	//	@EJB
	//private UserManagementLocal userManagementLocal;

	/**
	 * Default constructor.
	 */
	public InitDb() {
		// TODO Auto-generated constructor stub
	}

	
	@PostConstruct
	public void init() {

		
		
		User user=new User();
		user.setUserName("b");
		user.setAdress("bilov");
		user.setEmail("bilov");
		user.setFullName("bilov");
		user.setPassword("bv");
		

		
		userLocal.addUser(user);

		
		
		
		
	}
	
	



}

package fr.philae.busmapper.locator;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;



public class ServiceLocator {
	private static ServiceLocator instance;
	private Map<String, Object> cache;
	Context context;
 private ServiceLocator() {
	 cache=new HashMap<String, Object>();
	try {
		context =new InitialContext();
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
 public synchronized Object getProxy(String jndi){
	 if(cache.get(jndi)!=null)
		 return cache.get(jndi);
	 else{
		 Object object = null;
		try {
			object = context.lookup(jndi);
			 cache.put(jndi, object);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return object;
	 }
	 
 }
public static ServiceLocator getInstance() {
	if(instance==null)
		instance=new ServiceLocator();
	return instance;
}
}
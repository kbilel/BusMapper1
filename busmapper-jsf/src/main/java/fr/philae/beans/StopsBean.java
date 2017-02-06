package fr.philae.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.philae.busmapper.domain.Stops;

import fr.philae.busmapper.services.gestion.stop.StopServicesLocal;


@ManagedBean
@ViewScoped
public class StopsBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	StopServicesLocal local;
	Boolean form;
	
	
	private List<Stops> stops=new ArrayList<Stops>();
	private Stops stop=new Stops();
	
	
	public Boolean getForm() {
		return form;
	}
	public void setForm(Boolean form) {
		this.form = form;
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	public List<Stops> getStops() {
		return stops;
	}
	public void setStops(List<Stops> stops) {
		this.stops = stops;
	}
	public Stops getStop() {
		return stop;
	}
	public void setStop(Stops stop) {
		this.stop = stop;
	}
	@PostConstruct
	public void init(){
		form=true;
		stops=local.findAllStops();
	}
	
	
	
	
	public String doDeleteUser(Stops Order){
		local.deleteStop(Order);
		init();
		return null;
	}
	
	public String initialiser(){
		
		stop =new Stops();
		return null;
	}


	
	
	

}

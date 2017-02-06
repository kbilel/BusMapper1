package fr.philae.busmapper.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Feed
 *
 */
@Entity

public class Feed implements Serializable {

	
	private Integer id;
	private String notification;
	private String DateNotif;
	private static final long serialVersionUID = 1L;

	public Feed() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNotification() {
		return this.notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}
	public String getDateNotif() {
		return DateNotif;
	}
	public void setDateNotif(String dateNotif) {
		DateNotif = dateNotif;
	}
   
}

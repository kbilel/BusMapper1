package fr.philae.busmapper.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Calendar
 *
 */
@Entity

public class Calendar implements Serializable {

	
	private Integer service_id;
	private Integer monday;
	private Integer tuesday;
	private Integer wednesday;
	private Integer thursday;
	private Integer friday;
	private Integer saturday;
	private Integer sunday;
	private String start_date;
	private String end_date;
	private static final long serialVersionUID = 1L;

	public Calendar() {
		super();
	}   
	@Id    
	public Integer getService_id() {
		return this.service_id;
	}

	public void setService_id(Integer service_id) {
		this.service_id = service_id;
	}   
	public Integer getMonday() {
		return this.monday;
	}

	public void setMonday(Integer monday) {
		this.monday = monday;
	}   
	public Integer getTuesday() {
		return this.tuesday;
	}

	public void setTuesday(Integer tuesday) {
		this.tuesday = tuesday;
	}   
	public Integer getWednesday() {
		return this.wednesday;
	}

	public void setWednesday(Integer wednesday) {
		this.wednesday = wednesday;
	}   
	public Integer getThursday() {
		return this.thursday;
	}

	public void setThursday(Integer thursday) {
		this.thursday = thursday;
	}   
	public Integer getFriday() {
		return this.friday;
	}

	public void setFriday(Integer friday) {
		this.friday = friday;
	}   
	public Integer getSaturday() {
		return this.saturday;
	}

	public void setSaturday(Integer saturday) {
		this.saturday = saturday;
	}   
	public Integer getSunday() {
		return this.sunday;
	}

	public void setSunday(Integer sunday) {
		this.sunday = sunday;
	}   
	public String getStart_date() {
		return this.start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}   
	public String getEnd_date() {
		return this.end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
   
}

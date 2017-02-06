package fr.philae.busmapper.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tripstop
 *
 */
@Entity

public class Tripstop implements Serializable {

	   
	@Id
	private Integer id;
	private String abtripID;
	private String arrivaTime;
	private String departureTime;
	private Integer stopId;
	private Integer stopSequence;
	private static final long serialVersionUID = 1L;

	public Tripstop() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   

	public String getAbtripID() {
		return abtripID;
	}
	public void setAbtripID(String abtripID) {
		this.abtripID = abtripID;
	}
	public String getArrivaTime() {
		return this.arrivaTime;
	}

	public void setArrivaTime(String arrivaTime) {
		this.arrivaTime = arrivaTime;
	}   
	public String getDepartureTime() {
		return this.departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}   
	public Integer getStopId() {
		return this.stopId;
	}

	public void setStopId(Integer stopId) {
		this.stopId = stopId;
	}   
	public Integer getStopSequence() {
		return this.stopSequence;
	}

	public void setStopSequence(Integer stopSequence) {
		this.stopSequence = stopSequence;
	}

   
}

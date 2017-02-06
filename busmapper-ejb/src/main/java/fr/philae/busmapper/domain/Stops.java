package fr.philae.busmapper.domain;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Stops
 *
 */
@Entity

public class Stops implements Serializable {

	
	private Integer stopId;
	private String stopAName;
	private String stopDesc;
	private Float stopLat;
	private Float stopLon;
	private static final long serialVersionUID = 1L;

	public Stops() {
		super();
	}   
	@Id    
	public Integer getStopId() {
		return this.stopId;
	}

	public void setStopId(Integer stopId) {
		this.stopId = stopId;
	}   
	public String getStopAName() {
		return this.stopAName;
	}

	public void setStopAName(String stopAName) {
		this.stopAName = stopAName;
	}   
	public String getStopDesc() {
		return this.stopDesc;
	}

	public void setStopDesc(String stopDesc) {
		this.stopDesc = stopDesc;
	}   
	public Float getStopLat() {
		return this.stopLat;
	}

	public void setStopLat(Float stopLat) {
		this.stopLat = stopLat;
	}   
	public Float getStopLon() {
		return this.stopLon;
	}

	public void setStopLon(Float stopLon) {
		this.stopLon = stopLon;
	}
   
}

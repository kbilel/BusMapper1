package fr.philae.busmapper.domain;


import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Trips
 *
 */
@Entity

public class Trips implements Serializable {

	
	private Integer route_id;
	private Integer service_id;
	private Integer trip_id;
	private Integer trip_headsign;
	private Integer direction_id;
	private Integer trip_short_name;
	private Integer shape_id;
	private static final long serialVersionUID = 1L;

	public Trips() {
		super();
	}   
	public Integer getRoute_id() {
		return this.route_id;
	}

	public void setRoute_id(Integer route_id) {
		this.route_id = route_id;
	}   
	public Integer getService_id() {
		return this.service_id;
	}

	public void setService_id(Integer service_id) {
		this.service_id = service_id;
	}   
	
	@Id  
	public Integer getTrip_id() {
		return this.trip_id;
	}

	public void setTrip_id(Integer trip_id) {
		this.trip_id = trip_id;
	}   
	  
	public Integer getTrip_headsign() {
		return this.trip_headsign;
	}

	public void setTrip_headsign(Integer trip_headsign) {
		this.trip_headsign = trip_headsign;
	}   
	public Integer getDirection_id() {
		return this.direction_id;
	}

	public void setDirection_id(Integer direction_id) {
		this.direction_id = direction_id;
	}   
	public Integer getTrip_short_name() {
		return this.trip_short_name;
	}

	public void setTrip_short_name(Integer trip_short_name) {
		this.trip_short_name = trip_short_name;
	}   
	public Integer getShape_id() {
		return this.shape_id;
	}

	public void setShape_id(Integer shape_id) {
		this.shape_id = shape_id;
	}
   
}

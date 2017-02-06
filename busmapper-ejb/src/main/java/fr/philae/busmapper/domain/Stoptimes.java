package fr.philae.busmapper.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.text.DateFormat;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Stoptimes
 *
 */
@Entity

public class Stoptimes implements Serializable {

	private Integer _idTosolveidRequiredproblem;
	@Column(name="trip_id")
	private Integer tripId;
	@Column(name="arrival_time")
	private DateFormat arrivalTime;
	private DateFormat departure_time;
	private Integer stop_id;
	private Integer stop_sequence;
	private static final long serialVersionUID = 1L;

	public Stoptimes() {
		super();
	}   
	public Integer getTripId() {
		return this.tripId;
	}

	public void setTripId(Integer tripId) {
		this.tripId = tripId;
	}   
	public DateFormat getArrivalTime() {
		return this.arrivalTime;
	}

	public void setArrivalTime(DateFormat arrival_time) {
		this.arrivalTime = arrival_time;
	}   
	public DateFormat getDeparture_time() {
		return this.departure_time;
	}

	public void setDeparture_time(DateFormat departure_time) {
		this.departure_time = departure_time;
	}   
	public Integer getStop_id() {
		return this.stop_id;
	}

	public void setStop_id(Integer stop_id) {
		this.stop_id = stop_id;
	}   
	public Integer getStop_sequence() {
		return this.stop_sequence;
	}

	public void setStop_sequence(Integer stop_sequence) {
		this.stop_sequence = stop_sequence;
	}
	
	@Id
	public Integer get_idTosolveidRequiredproblem() {
		return _idTosolveidRequiredproblem;
	}
	public void set_idTosolveidRequiredproblem(
			Integer _idTosolveidRequiredproblem) {
		this._idTosolveidRequiredproblem = _idTosolveidRequiredproblem;
	}
	
   
}

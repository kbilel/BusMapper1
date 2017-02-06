package fr.philae.busmapper.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Agency
 *
 */
@Entity

public class Agency implements Serializable {

	   
	@Id
	private Integer agencyId;
	private String agencyName;
	private String agencyUrl;
	private static final long serialVersionUID = 1L;

	public Agency() {
		super();
	}   
	public Integer getAgencyId() {
		return this.agencyId;
	}

	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
	}   
	public String getAgencyName() {
		return this.agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}   
	public String getAgencyUrl() {
		return this.agencyUrl;
	}

	public void setAgencyUrl(String agencyUrl) {
		this.agencyUrl = agencyUrl;
	}
   
}

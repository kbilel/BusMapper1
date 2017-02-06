package fr.philae.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class FrameBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private String frameMap="http://data.ratp.fr/explore/embed/dataset/accessibilite-des-arrets-de-bus-ratp/map/?q=&location=13,48.85591,2.36086&static=false&datasetcard=false" ;

private String frameTable="http://data.ratp.fr/explore/embed/dataset/accessibilite-des-arrets-de-bus-ratp/table/?q=&location=13,48.85591,2.36086&static=false&datasetcard=false";

	public String getFrameMap() {
		return frameMap;
	}



	public void setFrameMap(String frameMap) {
		this.frameMap = frameMap;
	}



	public String getFrameTable() {
		return frameTable;
	}



	public void setFrameTable(String frameTable) {
		this.frameTable = frameTable;
	}


}

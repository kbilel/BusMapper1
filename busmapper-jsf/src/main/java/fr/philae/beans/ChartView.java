package fr.philae.beans;



import javax.annotation.PostConstruct;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.PieChartModel;

import fr.philae.busmapper.services.gestion.user.UserServicesLocal;
 
@ManagedBean
public class ChartView implements Serializable {
 
	@EJB
	UserServicesLocal local;
	private Integer nMale,nFemale;
    private PieChartModel pieModel1;
    private PieChartModel pieModel2;
 
    @PostConstruct
    public void init() {
        createPieModels();
      
        
    }
 
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
     
    public PieChartModel getPieModel2() {
        return pieModel2;
    }
     
    private void createPieModels() {
        createPieModel1();
        createPieModel2();
    }
 
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
        nMale=local.findNumberUserByGender("Male");
        nFemale=local.findNumberUserByGender("Female");
        pieModel1.set("Male", nMale);
        pieModel1.set("Female", nFemale);
       
         
        pieModel1.setTitle("Gender");
        pieModel1.setLegendPosition("w");
      
    }
     
    private void createPieModel2() {
        pieModel2 = new PieChartModel();
        nMale=local.findNumberUserByGender("Male");
        nFemale=local.findNumberUserByGender("Female");
        pieModel2.set("Male", nMale);
        pieModel2.set("Female", nFemale);
     
         
        pieModel2.setTitle("Gender pourcentage ");
        pieModel2.setLegendPosition("e");
        pieModel2.setFill(false);
        pieModel2.setShowDataLabels(true);
        pieModel2.setDiameter(150);
    }
     
}
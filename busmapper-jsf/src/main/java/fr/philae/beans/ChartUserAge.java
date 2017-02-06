package fr.philae.beans;


import javax.annotation.PostConstruct;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;

import fr.philae.busmapper.services.gestion.user.UserServicesLocal;
 
@ManagedBean
public class ChartUserAge implements Serializable {
 
	@EJB
	UserServicesLocal local;
	private Integer range1020,range2030,range3040;
    private BarChartModel barModel;
    private HorizontalBarChartModel horizontalBarModel;
 
    @PostConstruct
    public void init() {
        createBarModels();
    }
 
    public BarChartModel getBarModel() {
        return barModel;
    }
     
    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }
 
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        range1020=local.findNumberUserByAgeRange(10, 20);
        range2030=local.findNumberUserByAgeRange(20	, 30);
        range3040=local.findNumberUserByAgeRange(10, 20);
        
        ChartSeries students = new ChartSeries();
        students.setLabel("10 -20");
        students.set("20 - 30", range1020);
     
 
        ChartSeries employees = new ChartSeries();
        employees.setLabel("20 - 30");
        employees.set("20 - 30", range2030*20);

        ChartSeries others = new ChartSeries();
        others.setLabel("30 - 40");
        others.set("30 - 40", 34);
     


        
 
        model.addSeries(students);
        model.addSeries(employees);
        model.addSeries(others);
         
        return model;
    }
     
    private void createBarModels() {
        createBarModel();
    
    }
     
    private void createBarModel() {
        barModel = initBarModel();
        barModel.setAnimate(true);
   
         
        barModel.setTitle("");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Users disposotion by range age");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Number");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
     
   
 
}
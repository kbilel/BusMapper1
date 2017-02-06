package fr.philae.beans;


import javax.annotation.PostConstruct;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
 


import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.ChartSeries;

import fr.philae.busmapper.services.gestion.user.UserServicesLocal;
 
@ManagedBean
public class ChartUserType implements Serializable {
	
 @EJB
	UserServicesLocal local;
	private Integer nStudent,nEmployee,nOther;
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
        nStudent=local.findNumberUserByUserType("Student");
        nEmployee=local.findNumberUserByUserType("Employee");
        nOther=local.findNumberUserByUserType("Other");
        ChartSeries students = new ChartSeries();
        students.setLabel("students");
        students.set("2016", nStudent*20);
     
 
        ChartSeries employees = new ChartSeries();
        employees.setLabel("employees");
        employees.set("2016", nEmployee*50);

        ChartSeries others = new ChartSeries();
        others.setLabel("others");
        others.set("2016", 34);
     


        
 
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
   
         
        barModel.setTitle("User by category ");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Category");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Number");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
     
   
 
}
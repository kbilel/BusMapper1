package fr.philae.beans;
 

import javax.annotation.PostConstruct;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;








import javax.annotation.PostConstruct;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;

import fr.philae.busmapper.services.gestion.user.UserServicesLocal;






@ManagedBean
@ViewScoped
public class CustomerAccountChart implements Serializable {
    @EJB 
	UserServicesLocal local;
   private LineChartModel animatedModel1;
   private BarChartModel animatedModel2;
   public Integer platinumUnit;
   public Integer silverUnit;
   public Integer goldUnit;
 

   @PostConstruct
   public void init() {
       createAnimatedModels();
   }
   
   
 

   public LineChartModel getAnimatedModel1() {
       return animatedModel1;
   }

   public BarChartModel getAnimatedModel2() {
       return animatedModel2;
   }

   private void createAnimatedModels() {
	 
	   
	   
       animatedModel1 = initLinearModel();
       
     
	   
       animatedModel1.setTitle("Line Chart");
       animatedModel1.setAnimate(true);
       animatedModel1.setLegendPosition("se");
       Axis yAxis = animatedModel1.getAxis(AxisType.Y);
       yAxis.setMin(0);
       yAxis.setMax(10);
        
       animatedModel2 = initBarModel();
       animatedModel2.setTitle("Bar Charts");
       animatedModel2.setAnimate(true);
       animatedModel2.setLegendPosition("ne");
       yAxis = animatedModel2.getAxis(AxisType.Y);
       yAxis.setMin(0);
       yAxis.setMax(100);
   }
    
   private BarChartModel initBarModel() {
       BarChartModel model = new BarChartModel();

       
	   platinumUnit=local.findNumberUserByAge(18);
	   silverUnit=local.findNumberUserByStation("Brasilia");
	   goldUnit=local.findNumberUserByGender("Female");
	   
       ChartSeries platChart = new ChartSeries();
       platChart.setLabel("Platinum");
    
       platChart.set("2013", 15);
       platChart.set("2014", 30);
       platChart.set("2015", platinumUnit*15);

       ChartSeries silvChart = new ChartSeries();
       silvChart.setLabel("Silver");
      
       silvChart.set("2013", 10);
       silvChart.set("2014", 40);
       silvChart.set("2015", silverUnit*15);
       
       ChartSeries goldChart = new ChartSeries();
       goldChart.setLabel("Gold");
     
       goldChart.set("2013", 5);
       goldChart.set("2014", 15);
       goldChart.set("2015", goldUnit*15);
       
       model.addSeries(silvChart);
       model.addSeries(platChart);
       model.addSeries(goldChart);
        
       return model;
   }
    
   private LineChartModel initLinearModel() {
       LineChartModel model = new LineChartModel();

       LineChartSeries platLineChart = new LineChartSeries();
       platLineChart.setLabel("Platinum");

       platLineChart.set(1, 1);
       platLineChart.set(2, 2);
       platLineChart.set(3, 5);
       platLineChart.set(4, 8);
       platLineChart.set(5, platinumUnit);

       LineChartSeries SilvLineChart = new LineChartSeries();
       SilvLineChart.setLabel("Silver");
       
       SilvLineChart.set(1, 6);
       SilvLineChart.set(2, 3);
       SilvLineChart.set(3, 2);
       SilvLineChart.set(4, 7);
       SilvLineChart.set(5, silverUnit);
       
       LineChartSeries goldLineChart = new LineChartSeries();
       goldLineChart.setLabel("Gold");

       goldLineChart.set(1, 2);
       goldLineChart.set(2, 6);
       goldLineChart.set(3, 3);
       goldLineChart.set(4, 5);
       goldLineChart.set(5, goldUnit);

      
       model.addSeries(SilvLineChart);
       model.addSeries(platLineChart);
       model.addSeries(goldLineChart);
       
        
       return model;
   }
   
}
package fr.philae.beans;



import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
@ManagedBean
public class RemoteCommandView {
	 private int number;
	 
	    public int getNumber() {
	        return number;
	    }
	 
	    public void increment() {
	        number++;
	    }
    public void execute() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Executed", "Using RemoteCommand."));
    }
}
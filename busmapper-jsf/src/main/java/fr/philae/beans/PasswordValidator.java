package fr.philae.beans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import fr.philae.busmapper.services.gestion.user.UserServicesLocal;

@ManagedBean
@RequestScoped
public class PasswordValidator implements Validator {

    @EJB
    private UserServicesLocal userServicesLocal;



    public void validate(FacesContext context, UIComponent component, Object submittedValue) throws ValidatorException {
        if (submittedValue == null) {
            return; // Let required="true" handle.
        }
        
        
       
        String password = (String) submittedValue;
       
       

        if (password.equalsIgnoreCase("holaa")) {
        	System.out.println("hahou t"+password);
            throw new ValidatorException(new FacesMessage("Unot matched"));
        }
    }

}
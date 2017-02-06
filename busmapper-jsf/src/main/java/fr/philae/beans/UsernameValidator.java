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
public class UsernameValidator implements Validator {

    @EJB
    private UserServicesLocal userServicesLocal;

    public void validate(FacesContext context, UIComponent component, Object submittedValue) throws ValidatorException {
        if (submittedValue == null) {
            return; // Let required="true" handle.
        }

        String username = (String) submittedValue;

        if (userServicesLocal.exist(username)) {
        	System.out.println("hahou exist");
            throw new ValidatorException(new FacesMessage("Username already in use, choose another !"));
        }
    }

}
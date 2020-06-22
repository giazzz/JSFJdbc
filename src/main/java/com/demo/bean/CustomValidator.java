package com.demo.bean;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("CustomValidator")
public class CustomValidator implements Validator {

    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String value = (String) o;
        if (value.length() < 6) {
            FacesMessage mes = new FacesMessage("Tối thiểu 6 ký tự");
            mes.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(mes);
        }
    }
}

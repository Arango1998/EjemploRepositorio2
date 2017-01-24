package beans;

import clases.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

@Named(value = "personaBean")
@Dependent
public class personaBean {

    private Persona persona = new Persona();
    private List<Persona> lstPersonas = new ArrayList<Persona>();

    public personaBean() {
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(List<Persona> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }

    public void registrar() {
        this.lstPersonas.add(this.persona);
    }

    public void validar(FacesContext context,
            UIComponent toValidate, Object value) {
        context = FacesContext.getCurrentInstance();
        String texto = (String) value;
        if (!texto.equalsIgnoreCase("M") && !texto.equalsIgnoreCase("F")) {
            ((UIInput) toValidate).setValid(false);
            context.addMessage(toValidate.getClientId(context), new FacesMessage("Sexo No valido"));
        }
    }
}

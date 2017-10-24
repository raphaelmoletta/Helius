package br.edu.utfpr.dainf.eex23.helius.bs.web.managedbeans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author rapha
 */
@ManagedBean(name = "language")
@SessionScoped
public class LanguageMB implements Serializable {

    private static final long serialVersionUID = 1L;

    private String localeCode;

    private static final Map<String, Object> countries;

    static {
        countries = new HashMap<>();
        countries.put("Inglês", Locale.forLanguageTag("en_US"));
        countries.put("Português", Locale.forLanguageTag("pt_BR")); //label, value
    }

    public Map<String, Object> getCountriesInMap() {
        return countries;
    }

    public String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    //value change event listener
    public void countryLocaleCodeChanged(ValueChangeEvent e) {

        String newLocaleValue = e.getNewValue().toString();

        //loop country map to compare the locale code
        for (Map.Entry<String, Object> entry : countries.entrySet()) {

            if (entry.getValue().toString().equals(newLocaleValue)) {

                FacesContext.getCurrentInstance()
                        .getViewRoot().setLocale((Locale) entry.getValue());

            }
        }
    }

}

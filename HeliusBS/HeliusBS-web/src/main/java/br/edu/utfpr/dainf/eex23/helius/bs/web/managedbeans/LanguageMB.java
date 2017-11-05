package br.edu.utfpr.dainf.eex23.helius.bs.web.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

/**
 *
 * @author rapha
 */
@Named(value = "language")
@SessionScoped
public class LanguageMB implements Serializable {

    private static final long serialVersionUID = 294464674528869200L;

    private Locale locale;
    private static final List<Locale> COUNTRIES;

    static {
        COUNTRIES = new ArrayList<>();
        COUNTRIES.add(Locale.forLanguageTag("pt_BR"));
        COUNTRIES.add(Locale.forLanguageTag("en_US"));
        Collections.sort(COUNTRIES, new Comparator<Locale>() {
            @Override
            public int compare(Locale o1, Locale o2) {
                return o1.getDisplayLanguage().compareTo(o2.getDisplayLanguage());
            }

        });
    }

    @PostConstruct
    public void init() {
        locale = FacesContext.getCurrentInstance()
                .getViewRoot().getLocale();
        if(!COUNTRIES.contains(locale)) {
            locale = Locale.getDefault();
        }
        /*
        Locale l = FacesContext.getCurrentInstance()
                .getViewRoot().getLocale();
        System.out.println("\ngetCountry :" + l.getCountry());
        System.out.println("\ngetDisplayCountry :" + l.getDisplayCountry());
        System.out.println("\ngetDisplayLanguage :" + l.getDisplayLanguage());
        System.out.println("\ngetDisplayName :" + l.getDisplayName());
        System.out.println("\ngetDisplayScript :" + l.getDisplayScript());
        System.out.println("\ngetDisplayVariant :" + l.getDisplayVariant());
        System.out.println("\ngetISO3Country :" + l.getISO3Country());
        System.out.println("\ngetISO3Language :" + l.getISO3Language());
        System.out.println("\ngetLanguage :" + l.getLanguage());
        System.out.println("\ngetScript :" + l.getScript());
        System.out.println("\ngetVariant :" + l.getVariant());
        System.out.println("\toLanguageTag :" + l.toLanguageTag());
        */
    }

    public List<Locale> getCountriesInMap() {
        return COUNTRIES;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    //value change event listener
    public void countryLocaleCodeChanged(ValueChangeEvent e) {
        FacesContext.getCurrentInstance()
                .getViewRoot().setLocale((Locale) e.getNewValue());

    }

}

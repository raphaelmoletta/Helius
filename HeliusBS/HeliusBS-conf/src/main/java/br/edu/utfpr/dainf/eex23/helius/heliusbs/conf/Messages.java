package br.edu.utfpr.dainf.eex23.helius.heliusbs.conf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 *
 * @author rapha
 */
public class Messages {

    private ResourceBundle rb = null;
    private static Messages msgs = null;

    private Messages() {

    }

    private static void verifyMessages() {
        if (msgs == null) {
            msgs = new Messages();
        }
    }

    public static String get(String message) {
        Messages.verifyMessages();
        return msgs.getMessage(message);
    }

    public static void setDefault() {
        Messages.verifyMessages();
    }

    public static void set(String language, String country) {
        Messages.verifyMessages();
        if (language == null || language.isEmpty()) {
            msgs.set(new Locale("pt", "br"));
        } else {
            if (country == null || country.isEmpty()) {
                msgs.set(new Locale(language));
            } else {
                msgs.set(new Locale(language, country));
            }
        }
    }

    public static List<String> getAvaliableLocations() {
        return msgs.getLocations();
    }

    private void set(Locale locale) {
        if (locale == null) {
            rb = ResourceBundle.getBundle("i18n/Messages", new Locale("pt", "br"));
        }
        rb = ResourceBundle.getBundle("i18n/Messages", locale);
    }

    private String getMessage(String message) {
        return rb.getString(message);
    }

    private List<String> getLocations() {
        List<String> resourceBundles = new ArrayList<>();

        for (Locale locale : Locale.getAvailableLocales()) {
            try {
                ResourceBundle.getBundle("Messages", locale);
                resourceBundles.add(locale.getCountry());
            } catch (MissingResourceException ex) {

            }
        }
        Collections.sort(resourceBundles);
        return resourceBundles;
    }
}

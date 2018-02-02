package fr.simplifia.input.validator.impl;
import java.util.Locale;

public class SmpEngInputValidator extends SmpDefaultInputValidator {

    public SmpEngInputValidator(Locale locale) {
        super(locale);
        REGEXP ="([^éêè])*";
        MESSAGE ="The input given is not compatible with the english validation strategy";
    }
}

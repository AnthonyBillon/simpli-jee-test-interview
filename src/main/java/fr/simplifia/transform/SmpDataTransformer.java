package fr.simplifia.transform;

import fr.simplifia.input.validator.SmpInputValidator;
import fr.simplifia.input.validator.impl.AbstractSmpInputValidator;

public class SmpDataTransformer {

    private SmpInputValidator validator;
    private static String MESSAGE;
    public SmpDataTransformer(final SmpInputValidator validator) {
        this.validator = validator;
        switch (validator.getLocale().getLanguage()){
            case ("en"):
                MESSAGE = " : Welcome to Simplifia!";
                break;
            default:
                MESSAGE = " : bienvenue chez Simplifia!";
                break;
        }

    }

    public String transform(final String input){
        validator.validateInput(input);
        final StringBuffer buffer = new StringBuffer();
        buffer.append(input);
        buffer.append(MESSAGE);
        return buffer.toString();
    }

}
package fr.simplifia.input.validator.impl;

import fr.simplifia.input.exception.InputException;

import java.util.Locale;

public class SmpDefaultInputValidator extends AbstractSmpInputValidator {

    protected static String REGEXP = ".*";
    protected static String MESSAGE = "The input given is not compatible with the default validation strategy";

    protected SmpDefaultInputValidator(Locale locale) {
        super(locale);
    }

    @Override
    public void validateInput(final String input) throws InputException {
        if(!input.matches(REGEXP)){
            throw new InputException(MESSAGE);
        }
    }
}
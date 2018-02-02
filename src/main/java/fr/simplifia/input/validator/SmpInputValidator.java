package fr.simplifia.input.validator;

import fr.simplifia.input.exception.InputException;

import java.util.Locale;

public interface SmpInputValidator {
   void  validateInput(final String input) throws InputException;

    Locale getLocale();
}

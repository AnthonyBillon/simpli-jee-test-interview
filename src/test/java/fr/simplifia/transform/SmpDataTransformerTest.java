package fr.simplifia.transform;

import fr.simplifia.input.exception.InputException;
import fr.simplifia.input.validator.SmpInputValidator;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;


public class SmpDataTransformerTest {

    private SmpInputValidator validator;

    public SmpDataTransformerTest(){
        validator = Mockito.mock(SmpInputValidator.class);

        //Configuration of the validateInput method behavior
        doNothing().when(validator).validateInput("bonjour");
        doNothing().when(validator).validateInput("");
        doThrow(NullPointerException.class).when(validator).validateInput(null);
        doThrow(InputException.class).when(validator).validateInput("café");


    }

    @Test
    public void testTransformOk() throws Exception {

        when(validator.getLocale()).thenReturn(Locale.FRENCH).thenReturn(Locale.ENGLISH);

        SmpDataTransformer transformer = new SmpDataTransformer(validator);
        assertEquals(transformer.transform("bonjour"), "bonjour : bienvenue chez Simplifia!");
        transformer = new SmpDataTransformer(validator);
        assertEquals(transformer.transform("bonjour"), "bonjour : Welcome to Simplifia!");
        verify(validator, times(2)).validateInput("bonjour");
    }

    @Test(expectedExceptions = InputException.class)
    public void testTransformNotOk() throws Exception {
        when(validator.getLocale()).thenReturn(Locale.ENGLISH);
        SmpDataTransformer transformer = new SmpDataTransformer(validator);
        transformer.transform("café");
        verify(validator).validateInput("café");
    }


    @Test
    public void testTransformEmpty() throws Exception {

        when(validator.getLocale()).thenReturn(Locale.FRENCH).thenReturn(Locale.ENGLISH);

        SmpDataTransformer transformer = new SmpDataTransformer(validator);
        assertEquals(transformer.transform(""), " : bienvenue chez Simplifia!");
        transformer = new SmpDataTransformer(validator);
        assertEquals(transformer.transform(""), " : Welcome to Simplifia!");
        verify(validator, times(2)).validateInput("");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testTransformNull() throws Exception {
        when(validator.getLocale()).thenReturn(Locale.FRENCH);
        SmpDataTransformer transformer = new SmpDataTransformer(validator);
        transformer.transform(null);
    }


}
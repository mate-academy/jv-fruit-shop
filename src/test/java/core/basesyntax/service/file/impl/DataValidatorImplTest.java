package core.basesyntax.service.file.impl;

import static org.junit.Assert.assertTrue;

import core.basesyntax.service.file.DataValidator;
import java.util.List;
import org.junit.Test;

public class DataValidatorImplTest {
    @Test
    public void testCorrectInput() {
        List<String> list1 = List.of("P,Apple,22","S,Banana,10");
        List<String> list2 = List.of("r,tomato,56","b,Banana,70");
        DataValidator validator = new DataValidatorImpl();
        assertTrue(validator.validate(list1));
        assertTrue(validator.validate(list2));
    }

    @Test(expected = RuntimeException.class)
    public void testIncorrectInput() {
        List<String> list1 = List.of(",Apple,22","S,Banana,10");
        List<String> list2 = List.of("r,tomato,56","b,Banana,-70");
        List<String> list3 = List.of("F,tomato,56","b,Banana,70");
        DataValidator validator = new DataValidatorImpl();
        assertTrue(validator.validate(list1));
        assertTrue(validator.validate(list2));
        assertTrue(validator.validate(list3));
    }
}

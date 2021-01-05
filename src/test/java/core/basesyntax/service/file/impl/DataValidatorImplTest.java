package core.basesyntax.service.file.impl;

import static org.junit.Assert.assertTrue;

import core.basesyntax.service.file.DataReader;
import core.basesyntax.service.file.DataValidator;
import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataValidatorImplTest {
    private static DataValidator validator;
    private static DataReader reader;

    @BeforeClass
    public static void beforeClass() throws Exception {
        validator = new DataValidatorImpl();
        reader = new FileReader(validator);
    }

    @Test
    public void testCorrectInput() {
        List<String> list1 = List.of("P,Apple,22","S,Banana,10");
        assertTrue(validator.validate(list1));
        List<String> list2 = List.of("r,tomato,56","b,Banana,70");
        assertTrue(validator.validate(list2));
        List<String> list3 = new ArrayList<>();
        list3.add("Operation,Fruit,Amount");
        list3.add("b,Banana,70");
        assertTrue(validator.validate(list3));
    }

    @Test(expected = RuntimeException.class)
    public void test1IncorrectInput() {
        List<String> list1 = List.of(",Apple,22","S,Banana,10");
        assertTrue(validator.validate(list1));
    }

    @Test(expected = RuntimeException.class)
    public void test2IncorrectInput() {
        List<String> list2 = List.of("r,tomato,56","b,Banana,-70");
        assertTrue(validator.validate(list2));
    }

    @Test(expected = RuntimeException.class)
    public void test3IncorrectInput() {
        List<String> list2 = List.of("r,,56","b,Banana,70");
        assertTrue(validator.validate(list2));
    }

    @Test(expected = RuntimeException.class)
    public void test4IncorrectInput() {
        List<String> list2 = List.of("","b,Banana,70");
        assertTrue(validator.validate(list2));
    }
}

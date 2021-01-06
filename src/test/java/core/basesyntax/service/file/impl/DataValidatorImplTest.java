package core.basesyntax.service.file.impl;

import static org.junit.Assert.assertTrue;

import core.basesyntax.service.file.DataValidator;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataValidatorImplTest {
    private static DataValidator validator;

    @BeforeClass
    public static void beforeClass() {
        validator = new DataValidatorImpl();
    }

    @Test
    public void testCorrectInput() {
        List<String> list1 = List.of("Operation,Fruit,Amount", "P,Apple,22", "S,Banana,10");
        assertTrue(validator.validate(list1));
        List<String> list2 = List.of("Operation,Fruit,Amount", "r,tomato,56", "b,Banana,70");
        assertTrue(validator.validate(list2));
    }

    @Test(expected = RuntimeException.class)
    public void test1IncorrectInput() {
        List<String> list1 = List.of("Operation,Fruit,Amount", ",Apple,22", "S,Banana,10");
        validator.validate(list1);
    }

    @Test(expected = RuntimeException.class)
    public void test2IncorrectInput() {
        List<String> list2 = List.of("Operation,Fruit,Amount", "r,tomato,56", "b,Banana,-70");
        validator.validate(list2);
    }

    @Test(expected = RuntimeException.class)
    public void test3IncorrectInput() {
        List<String> list2 = List.of("Operation,Fruit,Amount", "r,,56", "b,Banana,70");
        validator.validate(list2);
    }

    @Test(expected = RuntimeException.class)
    public void test4IncorrectInput() {
        List<String> list2 = List.of("Operation,Fruit,Amount", "","b,Banana,70");
        validator.validate(list2);
    }
}

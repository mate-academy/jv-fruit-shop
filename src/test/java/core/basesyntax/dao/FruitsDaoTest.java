package core.basesyntax.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.db.Storage;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FruitsDaoTest {
    private static String[] array;
    private static List<String> expected;
    private static FruitsDao fruitsDaoTest;

    @BeforeAll
    static void setUp() {
        array = "abcdefghij".split("", 5);
        expected = Arrays.asList(array);
        fruitsDaoTest = new FruitsDaoImpl();
        fruitsDaoTest.setData(expected);
    }

    @Test
    void setData_Ok() {
        List<String> actual = Storage.data;
        assertEquals(actual, expected);
    }

    @Test
    void getData_Ok() {
        List<String> actual = fruitsDaoTest.getData();
        assertEquals(actual, expected);
    }
}

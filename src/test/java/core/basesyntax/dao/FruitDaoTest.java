package core.basesyntax.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.db.Storage;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FruitDaoTest {
    private static final String[] ARRAY = {"sds", "112", "1dsa", "sfsaf3", "Dfdss"};
    private static List<String> expected;
    private static FruitDao fruitsDaoTest;

    @BeforeAll
    static void setUp() {
        expected = Arrays.asList(ARRAY);
        fruitsDaoTest = new FruitDaoImpl();
        fruitsDaoTest.setData(expected);
    }

    @Test
    void put_data_ok() {
        List<String> actual = Storage.data;
        assertEquals(actual, expected);
    }

    @Test
    void get_data_ok() {
        List<String> actual = fruitsDaoTest.getData();
        assertEquals(actual, expected);
    }
}

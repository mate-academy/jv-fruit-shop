package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FruitDaoTest {
    private static final String[] ARRAY = {"sds", "112", "1dsa", "sfsaf3", "Dfdss"};
    private static List<String> expected;
    private static FruitDao fruitsDaoTest;

    @BeforeClass
    public static void setUp() {
        expected = Arrays.asList(ARRAY);
        fruitsDaoTest = new FruitDaoImpl();
        fruitsDaoTest.setData(expected);
    }

    @Test
    public void put_data_ok() {
        List<String> actual = Storage.data;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void get_data_ok() {
        List<String> actual = fruitsDaoTest.getData();
        Assert.assertEquals(actual, expected);
    }
}

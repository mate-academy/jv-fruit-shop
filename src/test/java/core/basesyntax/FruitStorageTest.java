package core.basesyntax;

import core.basesyntax.service.CsvFileReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class FruitStorageTest {
    private Map<String, Integer> expected;
    private CsvFileReader reader;
    private FruitStorage storage;

    @Before
    public void Before() {
        expected = new HashMap<>();
        reader = new CsvFileReader();
        storage = new FruitStorage();
        expected.put("banana", 97);
        expected.put("apple", 300);
    }

    @Test
    public void normalInputTest() {
        Map<String, Integer> actual = storage.createFruitStorage(reader.readFile("src/main/resources/NormalInput.csv"));
        Assert.assertEquals(expected, actual);
    }

    @Test (expected = RuntimeException.class)
    public void expiredFruitsSell() {
        Map<String, Integer> actual = storage.createFruitStorage(reader.readFile("src/main/resources/ExpiredSale.csv"));
    }

    @Test (expected = RuntimeException.class)
    public void notExistingFruitsSell() {
        Map<String, Integer> actual = storage.createFruitStorage(reader.readFile("src/main/resources/NotExistingFruitsSell.csv"));
    }

    @Test (expected = RuntimeException.class)
    public void notEnoughFruitsSell() {
        Map<String, Integer> actual = storage.createFruitStorage(reader.readFile("src/main/resources/NotEnoughFruits.csv"));
    }

}

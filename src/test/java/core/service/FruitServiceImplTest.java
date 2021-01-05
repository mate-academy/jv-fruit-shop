package core.service;

import static org.junit.Assert.assertEquals;

import core.db.Storage;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class FruitServiceImplTest {
    private static FruitService dataToString;

    @Before
    public void beforeClass() {
        dataToString = new FruitServiceImpl();
        Storage.fruits.put("banana", 150);
        Storage.fruits.put("mango", 150);
        Storage.fruits.put("lemon", 220);
        Storage.fruits.put("lime", 230);
        Storage.fruits.put("orange", 420);
    }

    @Test
    public void testForWork() {
        String firstExpected = "banana,150" + System.lineSeparator() + "mango,150"
                + System.lineSeparator() + "lemon,220" + System.lineSeparator() + "lime,230"
                + System.lineSeparator() + "orange,420";
        String firstActual = dataToString.generateFruitReport();
        assertEquals(firstExpected, firstActual);
        Storage.fruits.put("banana", 0);
        String secondExpected = "banana,0" + System.lineSeparator() + "mango,150"
                + System.lineSeparator() + "lemon,220" + System.lineSeparator() + "lime,230"
                + System.lineSeparator() + "orange,420";
        String secondActual = dataToString.generateFruitReport();
        assertEquals(secondExpected, secondActual);
    }

    @AfterClass
    public static void afterAll() {
        Storage.fruits.clear();
    }
}

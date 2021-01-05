package core.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.db.Storage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DataToStringImplTest {
    private static DataToString dataToString;
    private static final String STRING_FORMAT_FOR_WRONG =
            "Wrong operation! expected: %s But was: %s";

    @BeforeAll
    public static void beforeAll() {
        dataToString = new DataToStringImpl();
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
        String firstActual = dataToString.generateString();
        assertEquals(firstExpected, firstActual, String.format(STRING_FORMAT_FOR_WRONG,
                firstExpected, firstActual));
        Storage.fruits.put("banana", 0);
        String secondExpected = "banana,0" + System.lineSeparator() + "mango,150"
                + System.lineSeparator() + "lemon,220" + System.lineSeparator() + "lime,230"
                + System.lineSeparator() + "orange,420";
        String secondActual = dataToString.generateString();
        assertEquals(secondExpected, secondActual, String.format(STRING_FORMAT_FOR_WRONG,
                secondExpected, secondActual));
    }

    @AfterAll
    public static void afterAll() {
        Storage.fruits.clear();
    }
}
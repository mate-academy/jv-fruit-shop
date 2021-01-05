package core.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.db.Storage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FruitsDaoImplTest {
    private static FruitsDao fruitsDao;
    private static final String STRING_FORMAT_FOR_WRONG =
            "Wrong operation! expected: %s But was: %s";
    @BeforeAll
    static void beforeAll() {
        fruitsDao = new FruitsDaoImpl();
        Storage.fruits.put("banana", 150);
        Storage.fruits.put("mango", 150);
        Storage.fruits.put("lemon", 220);
        Storage.fruits.put("lime", 230);
        Storage.fruits.put("orange", 420);
    }

    @Test
    void testForAdd() {
        fruitsDao.add("apple", 20);
        int firstExpected = 6;
        int firstActual = Storage.fruits.size();
        assertEquals(firstExpected, firstActual, String.format(STRING_FORMAT_FOR_WRONG,
                firstExpected, firstActual));
        fruitsDao.add("banana", 20);
        int secondExpected = 6;
        int secondActual = Storage.fruits.size();
        assertEquals(secondExpected, secondActual, String.format(STRING_FORMAT_FOR_WRONG,
                secondExpected, secondActual));
    }

    @Test
    void testForGet() {
        int firstExpected = 20;
        int firstActual = fruitsDao.get("banana");
        int secondExpected = 0;
        int secondActual = fruitsDao.get("dog");
        assertEquals(firstExpected, firstActual, String.format(STRING_FORMAT_FOR_WRONG,
                firstExpected, firstActual));
        assertEquals(secondExpected, secondActual, String.format(STRING_FORMAT_FOR_WRONG,
                secondExpected, secondActual));
    }

    @AfterAll
    static void afterAll() {
        Storage.fruits.clear();
    }
}
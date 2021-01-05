package core.dao;

import static org.junit.Assert.assertEquals;

import core.db.Storage;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class FruitsDaoImplTest {
    private static FruitsDao fruitsDao;

    @BeforeClass
    public static void beforeAll() {
        fruitsDao = new FruitsDaoImpl();
        Storage.fruits.put("banana", 150);
        Storage.fruits.put("mango", 150);
        Storage.fruits.put("lemon", 220);
        Storage.fruits.put("lime", 230);
        Storage.fruits.put("orange", 420);
    }

    @Test
    public void testForAdd() {
        fruitsDao.add("apple", 20);
        int firstExpected = 6;
        int firstActual = Storage.fruits.size();
        assertEquals(firstExpected, firstActual);
        fruitsDao.add("banana", 20);
        int secondExpected = 6;
        int secondActual = Storage.fruits.size();
        assertEquals(secondExpected, secondActual);
    }

    @Test
    public void testForGet() {
        int firstExpected = 20;
        int firstActual = fruitsDao.get("banana");
        int secondExpected = 0;
        int secondActual = fruitsDao.get("dog");
        assertEquals(firstExpected, firstActual);
        assertEquals(secondExpected, secondActual);
    }

    @Test
    public void testForGetAll() {
        Map<String, Integer> firstExpected = new LinkedHashMap<>();
        firstExpected.put("banana", 20);
        firstExpected.put("mango", 150);
        firstExpected.put("lemon", 220);
        firstExpected.put("lime", 230);
        firstExpected.put("orange", 420);
        firstExpected.put("apple", 20);
        Map<String, Integer> firstActual = fruitsDao.getAll();
        assertEquals(firstExpected, firstActual);
    }

    @AfterClass
    public static void afterAll() {
        Storage.fruits.clear();
    }
}

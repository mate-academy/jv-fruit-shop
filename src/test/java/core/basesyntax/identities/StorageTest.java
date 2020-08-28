package core.basesyntax.identities;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.*;

public class StorageTest {

    private Storage testStorage;

    @Before
    public void setUp() throws Exception {
        testStorage = new Storage();

        testStorage.addFruit(new Fruit("banana", LocalDate.parse("2020-10-15")));
        testStorage.addFruit(new Fruit("banana", LocalDate.parse("2020-10-15")));
    }

    @Test
    public void addFruit_Ok() {
        Map<String, List<Fruit>> expected = new HashMap<>();
        expected.put("banana", new ArrayList<>());
        expected.get("banana").add(new Fruit("banana", LocalDate.parse("2020-10-15")));
        expected.get("banana").add(new Fruit("banana", LocalDate.parse("2020-10-15")));

        Map<String, List<Fruit>> actual = testStorage.getFruits();

        assertEquals(expected, actual);
    }

    @Test
    public void addFruit_AmountOfTypes_Ok() {
        int actual = testStorage.getFruits().entrySet().size();

        assertEquals(1, actual);
    }

    @Test
    public void addFruit_AmountOfFruits_Ok() {
        int actual = testStorage.getFruits().get("banana").size();

        assertEquals(2, actual);
    }

    @Test
    public void removeFruit_Ok() {
        Map<String, List<Fruit>> expected = new HashMap<>();
        expected.put("banana", new ArrayList<>());
        expected.get("banana").add(new Fruit("banana", LocalDate.parse("2020-10-15")));

        testStorage.removeFruit(new Fruit("banana", LocalDate.parse("2020-10-15")));
        Map<String, List<Fruit>> actual = testStorage.getFruits();

        assertEquals(expected, actual);
    }

    @Test
    public void removeFruit_AmountOfTypes_Ok() {
        testStorage.addFruit(new Fruit("apple", LocalDate.parse("2020-10-15")));
        testStorage.removeFruit(new Fruit("banana", LocalDate.parse("2020-10-15")));

        int actual = testStorage.getFruits().entrySet().size();

        assertEquals(2, actual);
    }

    @Test
    public void removeFruit_AmountOfFruits_Ok() {
        testStorage.addFruit(new Fruit("apple", LocalDate.parse("2020-10-15")));
        testStorage.removeFruit(new Fruit("banana", LocalDate.parse("2020-10-15")));

        int actual = testStorage.getFruits().get("banana").size();

        assertEquals(1, actual);
    }

    @Test (expected = NoSuchElementException.class)
    public void removeFruit_NoSuchElementException() {
        testStorage.removeFruit(new Fruit("apple", LocalDate.parse("2020-10-15")));
    }

    @Test
    public void currentAmountOfEachTypeOfFruit_Ok() {
        testStorage.addFruit(new Fruit("apple", LocalDate.parse("2020-10-15")));

        Map<String, Integer> expected = new HashMap<>();
        expected.put("banana", 2);
        expected.put("apple", 1);
        assertEquals(expected, testStorage.currentAmountOfEachTypeOfFruit());
    }
}
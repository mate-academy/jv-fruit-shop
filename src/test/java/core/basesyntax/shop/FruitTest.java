package core.basesyntax.shop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FruitTest {
    private static final String NAME = "apple";
    private static final String COMPARED_NAME = "cucumber";
    private static Fruit fruit;

    @BeforeAll
    static void beforeAll() {
        fruit = new Fruit(NAME);
    }

    @Test
    void getName_Ok() {
        String actual = fruit.getName();
        assertEquals(NAME, actual);
    }

    @Test
    void testEquals_Ok() {
        assertEquals(fruit, new Fruit(NAME));
        assertEquals(fruit, fruit);
        assertNotEquals(null, fruit);
        assertFalse(fruit.equals(""));
    }

    @Test
    void compareToVegetables_Ok() {
        int actual = fruit.compareTo(
                new Fruit(COMPARED_NAME));
        assertEquals(-2, actual);
    }

    @Test
    void compareToSame_Ok() {
        int actual = fruit.compareTo(
                new Fruit(NAME));
        assertEquals(0, actual);
    }
}

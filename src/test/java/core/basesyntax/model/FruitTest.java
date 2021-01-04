package core.basesyntax.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.db.Storage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FruitTest {
    static Fruit fruit;

    @BeforeAll
    static void beforeAll() {
        fruit = new Fruit();
    }

    @Test
    void inputDataToString_Ok() {
        fruit.setAmount(100);
        fruit.setFruitName("apple");
        assertEquals(new Fruit("apple", 100).toString(), fruit.toString());
        assertEquals("apple", fruit.getFruitName());
        assertEquals(100, fruit.getAmount());
        Storage.fruits.clear();
    }

    @Test
    void inputData_Ok() {
        fruit.setFruitName("banana");
        fruit.setAmount(0);
        assertEquals(new Fruit("banana", 0), fruit);
        assertEquals(new Fruit("banana", 0).hashCode(), fruit.hashCode());
        Storage.fruits.clear();
    }
}

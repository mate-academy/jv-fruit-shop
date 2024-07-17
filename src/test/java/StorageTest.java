import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.db.Storage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StorageTest {
    private Storage storage;

    @BeforeEach
    public void setUp() {
        storage = new Storage();
    }

    @Test
    public void testAddFruit() {
        storage.addFruit("apple", 10);
        assertEquals((Integer) 10, storage.getFruitQuantities().get("apple"));
    }

    @Test
    public void testRemoveFruit() {
        storage.addFruit("apple", 10);
        storage.removeFruit("apple", 5);
        assertEquals((Integer) 5, storage.getFruitQuantities().get("apple"));
    }

    @Test
    public void testRemoveFruitBeyondZero() {
        storage.addFruit("apple", 5);
        storage.removeFruit("apple", 10);
        assertEquals(Integer.valueOf(-5), storage.getFruitQuantities().get("apple"));
    }
}

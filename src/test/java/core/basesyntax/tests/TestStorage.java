package core.basesyntax.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class TestStorage {
    private static Map<Fruit, Integer> data = new HashMap<>();
    private static Map<Fruit, Integer> storage = Storage.getFruits();

    @BeforeEach
    public void setValues() {
        data.put(new Fruit("banana"), 100);
        data.put(new Fruit("apple"), 15);
        storage.put(new Fruit("banana"), 100);
        storage.put(new Fruit("apple"), 15);
    }

    @Test
    public void checkTwoMapEquals() {
        Storage.getFruits().clear();
        assertEquals(data.size(), storage.size(), "Size one not equal");
        assertEquals(data.keySet(), storage.keySet(), "Key's not equal");
        assertEquals(data.entrySet(), storage.entrySet(),
                "Key or value not equals");
        Fruit temp = new Fruit("lime");
        data.put(temp, 100);
        storage.put(temp, 100);
        assertEquals(data.size(), storage.size(), "Size two not equal");
        assertEquals(data.keySet(), storage.keySet(), "Key's not equal");
        assertEquals(data.entrySet(), storage.entrySet(),
                "Key or value not equals");
        data.clear();
        storage.clear();
    }

    @Test
    public void checkTwoMapNotEquals() {
        data.put(new Fruit("lime"), 75);
        assertNotEquals(data.size(), storage.size(),
                "Maps size must but not equals");
        assertNotEquals(data.keySet(), storage.keySet(),
                "Key's must be not equals");
        assertNotEquals(data.entrySet(), storage.entrySet(),
                "Key or value must be not equals");
    }
}

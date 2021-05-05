package core.basesyntax.db;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.shop.Fruit;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StorageTest {
    private static Map<Fruit, Integer> mapWithFruits;
    private static Fruit banana;

    @BeforeAll
    static void beforeAll() {
        mapWithFruits = new HashMap<>();
        banana = new Fruit("banana");
        mapWithFruits.put(banana, 100);
    }

    @Test
    void getFruits_Ok() {
        Storage.fruits.put(banana, 100);
        assertEquals(mapWithFruits, Storage.getFruits());
    }
}

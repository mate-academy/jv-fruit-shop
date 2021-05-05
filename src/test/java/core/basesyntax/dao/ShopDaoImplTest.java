package core.basesyntax.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import core.basesyntax.db.Storage;
import core.basesyntax.shop.Fruit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ShopDaoImplTest {
    private static ShopDao shopDao;
    private static Fruit fruit;

    @BeforeAll
    static void beforeAll() {
        shopDao = new ShopDaoImpl();
        fruit = new Fruit("banana");
    }

    @Test
    void addFruits_Ok() {
        boolean actual = shopDao.add(fruit, 100);
        assertTrue(actual);
    }

    @Test
    void getFruits_Ok() {
        Storage.fruits.put(fruit, 100);
        int actual = shopDao.get(fruit);
        int expected = 100;
        assertEquals(expected, actual);
    }
}

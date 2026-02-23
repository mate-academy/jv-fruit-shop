package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FruitDaoImplTest {
    private FruitDao fruitDao;

    @BeforeEach
    void setUp() {
        Storage.clear(); 
        fruitDao = new FruitDaoImpl();
    }

    @Test
    void add_validFruit_ok() {
        fruitDao.add("apple", 10);
        assertEquals(10, fruitDao.getQuantity("apple"));
    }

    @Test
    void add_NegativeBalance_throwsException() {
        assertThrows(RuntimeException.class, () -> {
            fruitDao.add("apple", -5);
        });
    }
}

package core.basesyntax.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FruitDaoImplTest {
    static FruitDao fruitDao;

    @BeforeAll
    static void beforeAll() {
        fruitDao = new FruitDaoImpl();
    }

    @Test
    void getByIndex_Ok() {
        Fruit fruit = new Fruit("banana", 0);
        fruitDao.add(fruit);
        assertEquals(fruit, fruitDao.get(0));
        Storage.fruits.clear();
    }

    @Test
    void getByName_Ok() {
        Fruit fruit = new Fruit("apple", 100);
        fruitDao.add(fruit);
        assertEquals(fruit, fruitDao.get("apple"));
        Storage.fruits.clear();
    }

    @Test
    void update_Ok() {
        Fruit fruit = new Fruit("apple", 11);
        fruitDao.add(fruit);
        fruitDao.update(fruitDao.get("apple"));
        assertEquals(fruit, fruitDao.get("apple"));
        Storage.fruits.clear();
    }
}

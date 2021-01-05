
package core.basesyntax.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FruitDaoImplTest {
    private static FruitDao fruitDao;

    @Before
    public void setUp() throws Exception {
        fruitDao = new FruitDaoImpl();
    }

    @After
    public void tearDown() throws Exception {
        Storage.fruits.clear();
    }

    @Test
    public void getByKey_Ok() {
        Fruit fruit = new Fruit("banana");
        fruitDao.add(fruit, 10);
        assertEquals(fruit, fruitDao.getFruit("banana"));
    }

    @Test
    public void containsKey_Ok() {
        Fruit fruit = new Fruit("apple");
        fruitDao.add(fruit, 100);
        assertTrue(fruitDao.containsKey(fruit));
    }

    @Test (expected = ArithmeticException.class)
    public void update_Ok() {
        Fruit fruit = new Fruit("apple");
        fruitDao.add(fruit, 11);
        fruitDao.update(fruitDao.getFruit("apple"), 5);
        assertEquals(16, fruitDao.getAmount("apple"));
        fruitDao.update(fruitDao.getFruit("apple"), -100);
    }

    @Test
    public void getSize_Ok() {
        assertEquals(0, fruitDao.getSize());
        fruitDao.add(new Fruit("apple"), 10);
        assertEquals(1, fruitDao.getSize());
    }

    @Test
    public void getAllFruits_Ok() {
        fruitDao.add(new Fruit("apple"), 10);
        String expected = "[Fruit{fruitName='apple'}=10]";
        assertEquals(expected, fruitDao.getAllFruits().toString());
    }
}


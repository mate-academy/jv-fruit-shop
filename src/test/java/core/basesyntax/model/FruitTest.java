package core.basesyntax.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import core.basesyntax.db.Storage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FruitTest {
    private Fruit fruit;

    @Before
    public void beforeAll() {
        fruit = new Fruit();
    }

    @After
    public void tearDown() throws Exception {
        Storage.fruits.clear();
    }

    @Test
    public void inputDataToString_Ok() {
        fruit.setFruitName("apple");
        assertEquals(new Fruit("apple").toString(), fruit.toString());
        assertEquals("apple", fruit.getFruitName());
    }

    @Test
    public void inputDataHashCode_Ok() {
        fruit.setFruitName("banana");
        assertEquals(new Fruit("banana"), fruit);
        assertTrue(new Fruit("banana").equals(fruit));
        assertFalse(new Fruit("apple").equals(fruit));
        assertFalse(fruit.equals(null));
        assertEquals(new Fruit("banana").hashCode(), fruit.hashCode());
    }
}

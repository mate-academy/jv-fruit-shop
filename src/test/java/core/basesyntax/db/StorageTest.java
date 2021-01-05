package core.basesyntax.db;

import static org.junit.Assert.assertEquals;

import core.basesyntax.model.Fruit;
import org.junit.After;
import org.junit.Test;

public class StorageTest {
    @After
    public void tearDown() throws Exception {
        Storage.fruits.clear();
    }

    @Test
    public void initialSize_Ok() {
        assertEquals(0, Storage.fruits.size());
        Storage.fruits.put(new Fruit(), 0);
        assertEquals(1, Storage.fruits.size());
    }
}

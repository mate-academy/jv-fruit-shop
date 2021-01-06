package core.basesyntax.dao;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.ShopItem;
import org.junit.BeforeClass;
import org.junit.Test;

public class OperationsDaoTest {
    public static final ShopItem BANANA = new ShopItem("banana");
    public static final ShopItem APPLE = new ShopItem("apple");
    public static final ShopItem PINEAPPLE = new ShopItem("pineapple");
    static OperationsDao dao;

    @BeforeClass
    public static void beforeAll() {
        dao = new OperationsDao();
    }

    @Test
    public void addToStorage_Ok() {
        dao.addToStorage(BANANA, 0);
        dao.addToStorage(APPLE, 21);
        dao.addToStorage(PINEAPPLE, 1337);
        Integer pineappleExpected = 1337;
        Integer appleExpected = 21;
        Integer bananaExpected = 0;
        assertEquals(pineappleExpected, Storage.storage.get(PINEAPPLE));
        assertEquals(appleExpected, Storage.storage.get(APPLE));
        assertEquals(bananaExpected, Storage.storage.get(BANANA));
    }

    @Test(expected = RuntimeException.class)
    public void addToStorageNegativeValue_ThrowsError() {
        dao.addToStorage(BANANA, -1);
    }

    @Test
    public void subtractFromStorage_Ok() {
        Storage.storage.put(PINEAPPLE, 1337);
        Storage.storage.put(BANANA, 0);
        dao.subtractFromStorage(PINEAPPLE, 1337);
        dao.subtractFromStorage(BANANA, 0);
    }

    @Test(expected = RuntimeException.class)
    public void subtractFromEmptyStorage_ThrowsError() {
        dao.subtractFromStorage(BANANA, 1337);
    }

    @Test(expected = RuntimeException.class)
    public void subtractMoreThanWeHaveFromStorage_ThrowsError() {
        Storage.storage.put(BANANA, 1);
        dao.subtractFromStorage(BANANA, 2);
    }
}

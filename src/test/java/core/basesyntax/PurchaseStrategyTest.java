package core.basesyntax;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.PurchaseHandler;
import org.junit.BeforeClass;
import org.junit.Test;

public class PurchaseStrategyTest {
    public static PurchaseHandler purchaseHandler;
    public static Fruit banana;

    @BeforeClass
    public static void beforeClass() {
        purchaseHandler = new PurchaseHandler();
        banana = new Fruit("banana");
    }

    @Test
    public void purchase_Ok() {
        Storage.getStorage().put(banana, 20);
        purchaseHandler.apply(banana, 1);
        Integer actual = Storage.getStorage().get(banana);
        Integer expected = 19;
        assertEquals(expected, actual);
        Storage.getStorage().clear();
    }

    @Test(expected = RuntimeException.class)
    public void purchaseBadData_NotOk() {
        Storage.getStorage().put(banana, 20);
        purchaseHandler.apply(banana, -1);
        Integer actual = Storage.getStorage().get(banana);
        Integer expected = 49;
        assertEquals(expected, actual);
        Storage.getStorage().clear();
    }

    @Test(expected = RuntimeException.class)
    public void purchaseMoreThanWeHave_NotOk() {
        Storage.getStorage().put(banana, 20);
        purchaseHandler.apply(banana, 100);
        Integer actual = Storage.getStorage().get(banana);
        Integer expected = 49;
        assertEquals(expected, actual);
        Storage.getStorage().clear();
    }
}

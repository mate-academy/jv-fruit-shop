package core.basesyntax;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.SupplyHandler;
import org.junit.BeforeClass;
import org.junit.Test;

public class SupplyStrategyTest {
    public static SupplyHandler supplyHandler;
    public static Fruit banana;

    @BeforeClass
    public static void beforeClass() {
        supplyHandler = new SupplyHandler();
        banana = new Fruit("banana");
    }

    @Test
    public void supply_Ok() {
        Storage.getStorage().put(banana, 20);
        supplyHandler.apply(banana, 1);
        Integer actual = Storage.getStorage().get(banana);
        Integer expected = 21;
        assertEquals(expected, actual);
        Storage.getStorage().clear();
    }

    @Test(expected = RuntimeException.class)
    public void supplyBadData_NotOk() {
        Storage.getStorage().put(banana, 20);
        supplyHandler.apply(banana, -1);
        Integer actual = Storage.getStorage().get(banana);
        Integer expected = 49;
        assertEquals(expected, actual);
        Storage.getStorage().clear();
    }
}

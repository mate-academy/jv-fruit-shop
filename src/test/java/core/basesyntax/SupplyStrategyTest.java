package core.basesyntax;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.strategy.SupplyHandler;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class SupplyStrategyTest {
    public static SupplyHandler supplyHandler;
    public static FruitService fruitService;
    public static Fruit banana;

    @BeforeClass
    public static void beforeClass() {
        supplyHandler = new SupplyHandler();
        fruitService = new FruitServiceImpl();
        banana = new Fruit("banana");
    }

    @After
    public void tearDown() {
        Storage.getStorage().clear();
    }

    @Test
    public void supply_Ok() {
        Storage.getStorage().put(banana, 20);
        supplyHandler.apply(banana, 1);
        Integer actual = Storage.getStorage().get(banana);
        assertEquals(Integer.valueOf(21), actual);
    }

    @Test(expected = RuntimeException.class)
    public void supplyBadData_NotOk() {
        Storage.getStorage().put(banana, 20);
        supplyHandler.apply(banana, -1);
        Integer actual = Storage.getStorage().get(banana);
        assertEquals(Integer.valueOf(49), actual);
    }
}

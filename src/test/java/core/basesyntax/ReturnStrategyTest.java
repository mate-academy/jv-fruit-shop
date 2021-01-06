package core.basesyntax;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.strategy.ReturnHandler;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReturnStrategyTest {
    public static ReturnHandler returnHandler;
    public static FruitService fruitService;
    public static Fruit banana;

    @BeforeClass
    public static void beforeClass() {
        returnHandler = new ReturnHandler();
        fruitService = new FruitServiceImpl();
        banana = new Fruit("banana");
    }

    @After
    public void tearDown() {
        Storage.getStorage().clear();
    }

    @Test
    public void return_Ok() {
        Storage.getStorage().put(banana, 20);
        returnHandler.apply(banana, 1);
        Integer actual = Storage.getStorage().get(banana);
        assertEquals(Integer.valueOf(21), actual);
    }

    @Test(expected = RuntimeException.class)
    public void returnBadData_NotOk() {
        Storage.getStorage().put(banana, 20);
        returnHandler.apply(banana, -1);
        Integer actual = Storage.getStorage().get(banana);
        assertEquals(Integer.valueOf(49), actual);
    }
}

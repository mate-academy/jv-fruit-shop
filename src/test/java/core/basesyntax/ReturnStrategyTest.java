package core.basesyntax;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.ReturnHandler;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReturnStrategyTest {
    public static ReturnHandler returnHandler;
    public static Fruit banana;

    @BeforeClass
    public static void beforeClass() {
        returnHandler = new ReturnHandler();
        banana = new Fruit("banana");
    }

    @Test
    public void return_Ok() {
        Storage.getStorage().put(banana, 20);
        returnHandler.apply(banana, 1);
        Integer actual = Storage.getStorage().get(banana);
        assertEquals(Integer.valueOf(21), actual);
        Storage.getStorage().clear();
    }

    @Test(expected = RuntimeException.class)
    public void returnBadData_NotOk() {
        Storage.getStorage().put(banana, 20);
        returnHandler.apply(banana, -1);
        Integer actual = Storage.getStorage().get(banana);
        Integer expected = 49;
        assertEquals(expected, actual);
        Storage.getStorage().clear();
    }
}

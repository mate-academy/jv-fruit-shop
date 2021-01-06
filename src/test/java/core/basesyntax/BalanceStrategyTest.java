package core.basesyntax;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.BalanceHandler;
import org.junit.BeforeClass;
import org.junit.Test;

public class BalanceStrategyTest {
    public static BalanceHandler balanceHandler;
    public static Fruit banana;

    @BeforeClass
    public static void beforeClass() {
        balanceHandler = new BalanceHandler();
    }

    @Test
    public void balance_Ok() {
        balanceHandler.apply(banana, 1);
        Integer actual = Storage.getStorage().get(banana);
        Integer expected = 1;
        assertEquals(expected, actual);
        Storage.getStorage().clear();
    }

    @Test(expected = RuntimeException.class)
    public void balanceBadData_NotOk() {
        balanceHandler.apply(banana, -1);
        Integer actual = Storage.getStorage().get(banana);
        Integer expected = 49;
        assertEquals(expected, actual);
        Storage.getStorage().clear();
    }
}

package core.basesyntax;

import core.basesyntax.service.ActionsWithFruits;
import core.basesyntax.service.impl.BuyAction;
import core.basesyntax.service.impl.SupplyAction;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

public class SupplyActionTest {

    @BeforeClass
    public static void beforeClass() throws Exception {
        Store.fruits.clear();
    }

    @Test
    public void applyActionOk() {
        Map<String, Integer> actual = Store.fruits;
        ActionsWithFruits supplyAction = new SupplyAction();
        supplyAction.actionWithStorage(new Transaction("s", "banana", "120", "2020-10-17"));

        Assert.assertEquals(120, (int) actual.get("banana"));
    }

    @Test(expected = RuntimeException.class)
    public void supplyWithNegativeNum() {
        ActionsWithFruits supplyAction = new SupplyAction();
        supplyAction.actionWithStorage(new Transaction("s", "banana", "-120", "2020-10-17"));
    }
}

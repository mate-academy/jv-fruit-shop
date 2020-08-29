package core.basesyntax;

import core.basesyntax.service.FruitAction;
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
        FruitAction supplyAction = new SupplyAction();
        supplyAction.applyAction(new Transaction("s", "banana", "120", "2020-10-17"));

        Assert.assertEquals(120, (int) actual.get("banana"));
    }

    @Test(expected = RuntimeException.class)
    public void supplyWithNegativeNum() {
        FruitAction supplyAction = new SupplyAction();
        supplyAction.applyAction(new Transaction("s", "banana", "-120", "2020-10-17"));
    }
}

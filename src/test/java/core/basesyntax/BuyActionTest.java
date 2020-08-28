package core.basesyntax;

import core.basesyntax.service.ActionsWithFruits;
import core.basesyntax.service.impl.BuyAction;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class BuyActionTest {
    private static ActionsWithFruits buyAction = new BuyAction();

    @Test
    public void buyActionOk() {
        Map<String, Integer> actual = Store.fruits;
        actual.put("banana", 100);
        buyAction.applyAction(new Transaction("b", "banana", "20", "2020-10-17"));

        Assert.assertEquals(80, (int) actual.get("banana"));
    }

    @Test(expected = RuntimeException.class)
    public void buyQuantityMoreThanExist() {
        Map<String, Integer> actual = Store.fruits;
        ActionsWithFruits buyAction = new BuyAction();
        actual.put("banana", 10);
        buyAction.applyAction(new Transaction("b", "banana", "20", "2020-10-17"));
    }
}

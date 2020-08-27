package core.basesyntax;

import core.basesyntax.service.ActionsWithFruits;
import core.basesyntax.service.FileReadService;
import core.basesyntax.service.impl.BuyAction;
import core.basesyntax.service.impl.FileReadServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class BuyActionTest {

    @Test
    public void buyActionOk() {
        Map<String, Integer> actual = Store.fruits;
        ActionsWithFruits buyAction = new BuyAction();
        actual.put("banana", 100);
        buyAction.actionWithStorage(new Transaction("b", "banana", "20", "2020-10-17"));

        Assert.assertEquals(80, (int) actual.get("banana"));
    }

    @Test(expected = RuntimeException.class)
    public void buyQuantityMoreThanExist() {
        Map<String, Integer> actual = Store.fruits;
        ActionsWithFruits buyAction = new BuyAction();
        actual.put("banana", 10);
        buyAction.actionWithStorage(new Transaction("b", "banana", "20", "2020-10-17"));
    }
}

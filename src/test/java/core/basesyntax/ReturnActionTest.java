package core.basesyntax;

import core.basesyntax.service.ActionsWithFruits;
import core.basesyntax.service.impl.ReturnAction;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

public class ReturnActionTest {

    @BeforeClass
    public static void beforeClass() throws Exception {
        Store.fruits.clear();
    }

    @Test
    public void returnActionOk() {
        Map<String, Integer> actual = Store.fruits;
        ActionsWithFruits returnAction = new ReturnAction();
        returnAction.applyAction(new Transaction("s", "banana", "120", "2020-10-17"));

        Assert.assertEquals(120, (int) actual.get("banana"));
    }

    @Test(expected = RuntimeException.class)
    public void returnWithNegativeNum() {
        ActionsWithFruits returnAction = new ReturnAction();
        returnAction.applyAction(new Transaction("s", "banana", "-120", "2020-10-17"));
    }
}

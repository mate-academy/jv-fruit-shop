package core.basesyntax;

import core.basesyntax.exceptions.WrongFruitsAmountException;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class OperationHandlerTest {
    private static Map<String, OperationHandler> operationHandlerMap;
    private static final String RETURN = "r";
    private static final String SUPPLY = "s";
    private static final String PURCHASE = "p";
    private static final String BALANCE = "b";

    @BeforeClass
    public static void setUp() {
        operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new BalanceOperationHandler());
        operationHandlerMap.put("p", new PurchaseOperationHandler());
        operationHandlerMap.put("s", new SupplyOperationHandler());
        operationHandlerMap.put("r", new ReturnOperationHandler());
    }

    @Test
    public void check_Return_ok() {
        Integer expected = 70;
        Integer actual = operationHandlerMap.get(RETURN)
                .updateBalance(50, 20);
        Assert.assertEquals(expected, actual);
        expected = 150;
        actual = operationHandlerMap.get(RETURN)
                .updateBalance(50, 100);
        Assert.assertEquals(expected, actual);

    }

    @Test(expected = WrongFruitsAmountException.class)
    public void check_Return_not_ok() {
        operationHandlerMap.get(RETURN).updateBalance(50, -2);
    }

    @Test
    public void check_Supply_ok() {
        Integer expected = 70;
        Integer actual = operationHandlerMap.get(SUPPLY)
                .updateBalance(50, 20);
        Assert.assertEquals(expected, actual);
        expected = 150;
        actual = operationHandlerMap.get(SUPPLY).updateBalance(50, 100);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = WrongFruitsAmountException.class)
    public void check_Supply_not_ok() {
        operationHandlerMap.get(SUPPLY).updateBalance(50, -1);
    }

    @Test
    public void check_Purchase_ok() {
        Integer expected = 30;
        Integer actual = operationHandlerMap.get(PURCHASE).updateBalance(50, 20);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = WrongFruitsAmountException.class)
    public void check_Purchase_not_ok() {
        operationHandlerMap.get(PURCHASE).updateBalance(50, -1);
    }

    @Test(expected = WrongFruitsAmountException.class)
    public void check_Purchase_not_ok_2() {
        operationHandlerMap.get(PURCHASE).updateBalance(50, 100);
    }

    @Test
    public void check_Balance_ok() {
        Integer expected = 70;
        Integer actual = operationHandlerMap.get(BALANCE).updateBalance(50, 20);
        Assert.assertEquals(expected, actual);
        expected = 150;
        actual = operationHandlerMap.get(BALANCE).updateBalance(50, 100);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = WrongFruitsAmountException.class)
    public void check_Balance_not_ok() {
        operationHandlerMap.get(BALANCE).updateBalance(50, -2);
    }
}

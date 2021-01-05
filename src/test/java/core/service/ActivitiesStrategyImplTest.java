package core.service;

import static org.junit.Assert.assertEquals;

import core.model.Operations;
import core.strategy.AmountHandler;
import core.strategy.BalanceAmountHandler;
import core.strategy.PurchaseAmountHandler;
import core.strategy.ReturnAmountHandler;
import core.strategy.SupplyAmountHandler;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class ActivitiesStrategyImplTest {
    private static ActivitiesStrategy activitiesStrategy;

    @Before
    public void beforeAll() {
        Map<Operations, AmountHandler> activitiesHandlerMap = new HashMap<>();
        activitiesHandlerMap.put(Operations.BALANCE, new BalanceAmountHandler());
        activitiesHandlerMap.put(Operations.SUPPLY, new SupplyAmountHandler());
        activitiesHandlerMap.put(Operations.RETURN, new ReturnAmountHandler());
        activitiesHandlerMap.put(Operations.PURCHASE, new PurchaseAmountHandler());
        activitiesStrategy = new ActivitiesStrategyImpl(activitiesHandlerMap);
    }

    @Test
    public void testForBalance() {
        Class<BalanceAmountHandler> firstExpected = BalanceAmountHandler.class;
        Class<? extends AmountHandler> firstActual = activitiesStrategy.get(Operations.BALANCE)
                .getClass();
        assertEquals(firstExpected, firstActual);
    }

    @Test
    public void testForPurchase() {
        Class<PurchaseAmountHandler> firstExpected = PurchaseAmountHandler.class;
        Class<? extends AmountHandler> firstActual = activitiesStrategy.get(Operations.PURCHASE)
                .getClass();
        assertEquals(firstExpected, firstActual);
    }

    @Test
    public void testForReturn() {
        Class<ReturnAmountHandler> firstExpected = ReturnAmountHandler.class;
        Class<? extends AmountHandler> firstActual = activitiesStrategy.get(Operations.RETURN)
                .getClass();
        assertEquals(firstExpected, firstActual);
    }

    @Test
    public void testForSupply() {
        Class<SupplyAmountHandler> firstExpected = SupplyAmountHandler.class;
        Class<? extends AmountHandler> firstActual = activitiesStrategy
                .get(Operations.operationFromString("s")).getClass();
        assertEquals(firstExpected, firstActual);
    }

    @Test(expected = RuntimeException.class)
    public void testForIncorrectData() {
        activitiesStrategy.get(null);
    }

    @Test(expected = RuntimeException.class)
    public void testForIncorrectDataSecond() {
        activitiesStrategy.get(Operations.operationFromString("1"));
    }

    @Test(expected = RuntimeException.class)
    public void testForIncorrectDataThird() {
        activitiesStrategy.get(Operations.operationFromString("%"));
    }
}

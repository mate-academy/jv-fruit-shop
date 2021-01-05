package core.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.model.Operations;
import core.strategy.AmountHandler;
import core.strategy.BalanceAmountHandler;
import core.strategy.PurchaseAmountHandler;
import core.strategy.ReturnAmountHandler;
import core.strategy.SupplyAmountHandler;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ActivitiesStrategyImplTest {
    private static ActivitiesStrategy activitiesStrategy;
    private static final String STRING_FORMAT_FOR_WRONG =
            "Wrong operation! expected: %s But was: %s";

    @BeforeAll
    public static void beforeAll() {
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
        assertEquals(firstExpected, firstActual,
                String.format(STRING_FORMAT_FOR_WRONG, firstExpected, firstActual));
    }

    @Test
    public void testForPurchase() {
        Class<PurchaseAmountHandler> firstExpected = PurchaseAmountHandler.class;
        Class<? extends AmountHandler> firstActual = activitiesStrategy.get(Operations.PURCHASE)
                .getClass();
        assertEquals(firstExpected, firstActual,
                String.format(STRING_FORMAT_FOR_WRONG, firstExpected, firstActual));
    }

    @Test
    public void testForReturn() {
        Class<ReturnAmountHandler> firstExpected = ReturnAmountHandler.class;
        Class<? extends AmountHandler> firstActual = activitiesStrategy.get(Operations.RETURN)
                .getClass();
        assertEquals(firstExpected, firstActual,
                String.format(STRING_FORMAT_FOR_WRONG, firstExpected, firstActual));
    }

    @Test
    public void testForSupply() {
        Class<SupplyAmountHandler> firstExpected = SupplyAmountHandler.class;
        Class<? extends AmountHandler> firstActual = activitiesStrategy
                .get(Operations.operationFromString("s")).getClass();
        assertEquals(firstExpected, firstActual,
                String.format(STRING_FORMAT_FOR_WRONG, firstExpected, firstActual));
    }

    @Test
    public void testForIncorrectData() {
        assertThrows(RuntimeException.class, () -> activitiesStrategy.get(null));
        assertThrows(RuntimeException.class, () -> activitiesStrategy
                .get(Operations.operationFromString("d")));
        assertThrows(RuntimeException.class, () -> activitiesStrategy
                .get(Operations.operationFromString("1")));
        assertThrows(RuntimeException.class, () -> activitiesStrategy
                .get(Operations.operationFromString("%")));
    }
}
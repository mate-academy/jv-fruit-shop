package core.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.activities.ActivitiesHandler;
import core.activities.BalanceActivitiesHandler;
import core.activities.PurchaseActivitiesHandler;
import core.activities.ReturnActivitiesHandler;
import core.activities.SupplyActivitiesHandler;
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
        Map<String, ActivitiesHandler> activitiesHandlerMap = new HashMap<>();
        activitiesHandlerMap.put("b", new BalanceActivitiesHandler());
        activitiesHandlerMap.put("s", new SupplyActivitiesHandler());
        activitiesHandlerMap.put("r", new ReturnActivitiesHandler());
        activitiesHandlerMap.put("p", new PurchaseActivitiesHandler());
        activitiesStrategy = new ActivitiesStrategyImpl(activitiesHandlerMap);
    }

    @Test
    public void testForBalance() {
        Class<BalanceActivitiesHandler> firstExpected = BalanceActivitiesHandler.class;
        Class<? extends ActivitiesHandler> firstActual = activitiesStrategy.get("b").getClass();
        assertEquals(firstExpected, firstActual,
                String.format(STRING_FORMAT_FOR_WRONG, firstExpected, firstActual));
    }

    @Test
    public void testForPurchase() {
        Class<PurchaseActivitiesHandler> firstExpected = PurchaseActivitiesHandler.class;
        Class<? extends ActivitiesHandler> firstActual = activitiesStrategy.get("p").getClass();
        assertEquals(firstExpected, firstActual,
                String.format(STRING_FORMAT_FOR_WRONG, firstExpected, firstActual));
    }

    @Test
    public void testForReturn() {
        Class<ReturnActivitiesHandler> firstExpected = ReturnActivitiesHandler.class;
        Class<? extends ActivitiesHandler> firstActual = activitiesStrategy.get("r").getClass();
        assertEquals(firstExpected, firstActual,
                String.format(STRING_FORMAT_FOR_WRONG, firstExpected, firstActual));
    }

    @Test
    public void testForSupply() {
        Class<SupplyActivitiesHandler> firstExpected = SupplyActivitiesHandler.class;
        Class<? extends ActivitiesHandler> firstActual = activitiesStrategy.get("s").getClass();
        assertEquals(firstExpected, firstActual,
                String.format(STRING_FORMAT_FOR_WRONG, firstExpected, firstActual));
    }

    @Test
    public void testForIncorrectData() {
        assertThrows(RuntimeException.class, () -> activitiesStrategy.get(null));
        assertThrows(RuntimeException.class, () -> activitiesStrategy.get("c"));
        assertThrows(RuntimeException.class, () -> activitiesStrategy.get("1"));
        assertThrows(RuntimeException.class, () -> activitiesStrategy.get("%"));
    }
}

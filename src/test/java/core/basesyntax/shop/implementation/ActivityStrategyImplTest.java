package core.basesyntax.shop.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.handlers.Activity;
import core.basesyntax.handlers.BalanceHandler;
import core.basesyntax.handlers.PurchaseHandler;
import core.basesyntax.handlers.ReturnHandler;
import core.basesyntax.handlers.SupplyHandler;
import core.basesyntax.shop.ActivitieStrategy;
import core.basesyntax.shop.Activities;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ActivityStrategyImplTest {
    public static final String ACTION = Activities.SUPPLY.getType();
    private static ActivitieStrategy strategy;
    private static Map<String, Activity> activitieMap = new HashMap<>();

    @BeforeAll
    static void beforeAll() {
        strategy = new ActivitieStrategyImpl();
        activitieMap.put(Activities.BALANCE.getType(), new BalanceHandler());
        activitieMap.put(Activities.SUPPLY.getType(), new SupplyHandler());
        activitieMap.put(Activities.PURCHASE.getType(), new PurchaseHandler());
        activitieMap.put(Activities.RETURN.getType(), new ReturnHandler());
    }

    @Test
    void getActivities_Ok() {
        Activity expected = activitieMap.get(ACTION);
        Activity actual = strategy.get(ACTION);
        assertEquals(expected.getClass(), actual.getClass());
    }
}

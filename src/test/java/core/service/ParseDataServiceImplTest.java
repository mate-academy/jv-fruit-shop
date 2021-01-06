package core.service;

import static org.junit.Assert.assertEquals;

import core.dao.FruitsDaoImpl;
import core.db.Storage;
import core.model.Operations;
import core.strategy.AmountHandler;
import core.strategy.BalanceAmountHandler;
import core.strategy.PurchaseAmountHandler;
import core.strategy.ReturnAmountHandler;
import core.strategy.SupplyAmountHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParseDataServiceImplTest {
    private static ParseDataService parseDataService;

    @Before
    public void beforeClass() {
        Map<Operations, AmountHandler> activitiesHandlerMap = new HashMap<>();
        activitiesHandlerMap.put(Operations.BALANCE, new BalanceAmountHandler());
        activitiesHandlerMap.put(Operations.SUPPLY, new SupplyAmountHandler());
        activitiesHandlerMap.put(Operations.RETURN, new ReturnAmountHandler());
        activitiesHandlerMap.put(Operations.PURCHASE, new PurchaseAmountHandler());
        ActivitiesStrategy activitiesStrategy = new ActivitiesStrategyImpl(activitiesHandlerMap);
        parseDataService = new ParseDataServiceImpl(activitiesStrategy, new FruitsDaoImpl());
    }

    @Test
    public void testForCorrectData() {
        List<String> list = List.of("b,banana,20", "b,apple,100", "b,kiwi,50", "b,mango,60",
                "b,lemon,70", "s,banana,100", "p,banana,13", "p,kiwi,30", "r,apple,10",
                "p,apple,20", "p,lemon,20", "p,banana,5", "s,banana,50", "s,lemon,10",
                "p,mango,30");
        parseDataService.applyOperationsToFruit(list);
        int firstExpected = 5;
        int firstActual = Storage.fruits.size();
        assertEquals(firstExpected, firstActual);

    }

    @Test
    public void testForCorrectDataSecond() {
        List<String> list = List.of("b,banana,20", "b,apple,100", "s,banana,100", "p,banana,13",
                "r,apple,10", "p,apple,20", "p,banana,5", "s,banana,50");
        parseDataService.applyOperationsToFruit(list);
        int firstExpected = 90;
        int firstActual = Storage.fruits.get("apple");
        assertEquals(firstExpected, firstActual);
    }

    @Test(expected = RuntimeException.class)
    public void testForIncorrectData() {
        parseDataService.applyOperationsToFruit(null);
    }

    @Test(expected = RuntimeException.class)
    public void testForIncorrectDataSecond() {
        List<String> list = List.of("b,banana,20", "b,apple,100", "s,banana,100", "p,banana,-13");
        parseDataService.applyOperationsToFruit(list);
    }

    @After
    public void clearStorage() {
        Storage.fruits.clear();
    }
}

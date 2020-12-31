package core.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.activities.ActivitiesHandler;
import core.activities.BalanceActivitiesHandler;
import core.activities.PurchaseActivitiesHandler;
import core.activities.ReturnActivitiesHandler;
import core.activities.SupplyActivitiesHandler;
import core.service.ActivitiesStrategy;
import core.service.ActivitiesStrategyImpl;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GetDataFromFileCsvTest {
    private static GetDataFromFile getDataFromFile;
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
    public void testForCorrectInputData() {
        getDataFromFile = new GetDataFromFileCsv(activitiesStrategy);
        String firstExpected = "banana,152" + System.lineSeparator() + "apple,90";
        String secondExpected = "banana,152" + System.lineSeparator() + "apple,90"
                + System.lineSeparator() + "kiwi,20" + System.lineSeparator() + "mango,30"
                + System.lineSeparator() + "lemon,60";
        String firstActual = getDataFromFile.getData("FruitShopChornovola.csv");
        String secondActual = getDataFromFile.getData("FruitShopUshakova.csv");
        assertEquals(firstExpected, firstActual,
                String.format(STRING_FORMAT_FOR_WRONG, firstExpected, firstActual));
        assertEquals(secondExpected, secondActual,
                String.format(STRING_FORMAT_FOR_WRONG, secondExpected, secondActual));
    }

    @Test
    public void testForIncorrectInputData() {
        assertThrows(RuntimeException.class,() ->
                getDataFromFile.getData("FruitShopLvivIncorrect.csv"));
        assertThrows(RuntimeException.class,() ->
                getDataFromFile.getData("FruitShopIrpinskaIncorrect.csv"));
        assertThrows(RuntimeException.class,() ->
                getDataFromFile.getData("FruitShopChornobilskaIncorrect.csv"));
        assertThrows(RuntimeException.class,() ->
                getDataFromFile.getData("TestTestTest.csv"));
        assertThrows(RuntimeException.class,() -> getDataFromFile.getData(""));
    }
}

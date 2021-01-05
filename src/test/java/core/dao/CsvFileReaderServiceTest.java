package core.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.db.Storage;
import core.model.Operations;
import core.service.ActivitiesStrategy;
import core.service.ActivitiesStrategyImpl;
import core.strategy.AmountHandler;
import core.strategy.BalanceAmountHandler;
import core.strategy.PurchaseAmountHandler;
import core.strategy.ReturnAmountHandler;
import core.strategy.SupplyAmountHandler;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CsvFileReaderServiceTest {
    private static FileReaderService fileReaderService;
    private static final String STRING_FORMAT_FOR_WRONG =
            "Wrong operation! expected: %s But was: %s";

    @BeforeAll
    public static void beforeAll() {
        Map<Operations, AmountHandler> activitiesHandlerMap = new HashMap<>();
        activitiesHandlerMap.put(Operations.BALANCE, new BalanceAmountHandler());
        activitiesHandlerMap.put(Operations.SUPPLY, new SupplyAmountHandler());
        activitiesHandlerMap.put(Operations.RETURN, new ReturnAmountHandler());
        activitiesHandlerMap.put(Operations.PURCHASE, new PurchaseAmountHandler());
        ActivitiesStrategy activitiesStrategy = new ActivitiesStrategyImpl(activitiesHandlerMap);
        fileReaderService = new CsvFileReaderService(activitiesStrategy);
    }

    @Test
    public void testForCorrectData() {
        int firstExpected = 5;
        fileReaderService.getData("src/test/resources/FruitShopUshakova.csv");
        int firstActual = Storage.fruits.size();
        assertEquals(firstExpected, firstActual, String.format(STRING_FORMAT_FOR_WRONG,
                firstExpected, firstActual));

    }

    @Test
    public void testForCorrectDataSecond() {
        int firstExpected = 90;
        fileReaderService.getData("src/test/resources/FruitShopChornovola.csv");
        int firstActual = Storage.fruits.get("apple");
        assertEquals(firstExpected, firstActual, String.format(STRING_FORMAT_FOR_WRONG,
                firstExpected, firstActual));
    }

    @Test
    public void testForIncorrectData() {
        assertThrows(RuntimeException.class,() ->
                fileReaderService.getData(
                        "src/test/resources/FruitShopLvivIncorrect.csv"));
        assertThrows(RuntimeException.class,() ->
                fileReaderService.getData(
                        "src/test/resources/FruitShopIrpinskaIncorrect.csv"));
        assertThrows(RuntimeException.class,() ->
                fileReaderService.getData(
                        "src/test/resources/FruitShopChornobilskaIncorrect.csv"));
        assertThrows(RuntimeException.class,() ->
                fileReaderService.getData("src/test/resources/TestTestTest.csv"));
        assertThrows(RuntimeException.class,() -> fileReaderService.getData(""));
    }

    @AfterEach
    public void clearStorage() {
        Storage.fruits.clear();
    }
}
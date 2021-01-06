package core.basesyntax.model;

import core.basesyntax.model.impl.FruitStoreImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class StoreTest {
    private static final String mainTest = "src/main/resources/FruitShopMorningData.csv";
    private static final String firstTest = "src/main/resources/FirstTest.csv";
    private static final String secondTest = "src/main/resources/SecondTest.csv";
    private static final String thirdTest = "src/main/resources/ThirdTest.csv";
    private static final String fourthTest = "src/main/resources/FourthTest.csv";
    private static final String mainResult = "src/main/resources/MainResult.csv";
    private static final String firstResult = "src/main/resources/FirstResult.csv";
    private static final String secondResult = "src/main/resources/SecondResult.csv";
    private static final String thirdResult = "src/main/resources/ThirdResult.csv";
    private static final String fourthResult = "src/main/resources/FourthResult.csv";
    private static Store store;

    @BeforeClass
    public static void setUp() {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new BalanceOperationHandler());
        operationHandlerMap.put("p", new PurchaseOperationHandler());
        operationHandlerMap.put("s", new SupplyOperationHandler());
        operationHandlerMap.put("r", new ReturnOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        store = new FruitStoreImpl(operationStrategy);
    }

    @Test
    public void getInfo_check_ok() {
        store.getInfo(mainTest, mainResult);
        String actual = readFile(mainResult).trim();
        String expected = "fruit,quantity" + System.lineSeparator()
                + "banana,165" + System.lineSeparator()
                + "orange,160" + System.lineSeparator()
                + "apple,420";
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void getStatistic_wrong_Operator() {
        store.getInfo(firstTest, firstResult);
    }

    @Test(expected = RuntimeException.class)
    public void getStatistic_negative_quantity() {
        store.getInfo(secondTest, secondResult);
    }

    @Test(expected = RuntimeException.class)
    public void getStatistic_invalid_quantity() {
        store.getInfo(thirdTest, thirdResult);
    }

    @Test
    public void getStatistic_balance_zero() {
        store.getInfo(fourthTest, fourthResult);
        String actual = readFile(fourthResult).trim();
        String expected = "fruit,quantity" + System.lineSeparator()
                + "banana,0";
        Assert.assertEquals(expected, actual);
    }

    private String readFile(String fileName) {
        try {
            return Files.readString(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from the file", e);
        }
    }
}

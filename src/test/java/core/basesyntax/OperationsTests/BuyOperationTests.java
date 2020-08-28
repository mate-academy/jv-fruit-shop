package core.basesyntax.OperationsTests;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitOperations;
import core.basesyntax.service.IOoperations.OperationHandler;
import core.basesyntax.service.IOoperations.Reader;
import core.basesyntax.service.impl.BuyFruitOperation;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BuyOperationTests {
    private static final Integer EXPECTED_QUANTITY = 90;
    private static final String KEY = "banana";
    private static FruitOperations buy;

    @BeforeClass
    public static void prepareEnvironmentBeforeTest() {
        buy = new BuyFruitOperation();
        Fruit.getFruitStorage().clear();
        OperationHandler.handleOperation(Reader.readFromFile("src/CsvFolder/buyTest.csv"));
    }

    @Test
    public void testBuyWithNormalData() {
        buy.doOperation(
                new FruitDto("b", KEY, "10", "2020-10-07"));
        Assert.assertEquals(EXPECTED_QUANTITY, Fruit.getFruitStorage().get(KEY).getAllFruitAmount());
    }

    @Test(expected = RuntimeException.class)
    public void testBuyWithRunOutOfFruits() {
        buy.doOperation(
                new FruitDto("b", KEY, "160", "2020-10-05"));
    }

    @Test(expected = RuntimeException.class)
    public void testBuyWithNonExistingFruit() {
        buy.doOperation(
                new FruitDto("b", "mango", "160", "2020-10-05"));
    }

}

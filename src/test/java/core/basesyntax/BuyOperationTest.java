package core.basesyntax;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.FruitStorage;
import core.basesyntax.service.FruitOperation;
import core.basesyntax.service.iooperations.OperationHandler;
import core.basesyntax.service.iooperations.Reader;
import core.basesyntax.service.impl.BuyFruitOperation;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BuyOperationTest {
    private static final Integer EXPECTED_QUANTITY = 90;
    private static final String KEY = "banana";
    private static FruitOperation buy;

    @BeforeClass
    public static void prepareEnvironmentBeforeTest() {
        buy = new BuyFruitOperation();
        FruitStorage.getFruitStorage().clear();
        new OperationHandler().handleOperation(new Reader().readFromFile("src/test/resources/buyTest.csv"));
    }

    @Test
    public void testBuyWithNormalData() {
        buy.doOperation(
                new FruitDto("b", KEY, "10", "2020-10-07"));
        Assert.assertEquals(EXPECTED_QUANTITY, FruitStorage.getFruitStorage().get(KEY).getAllFruitAmount());
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

package core.basesyntax.operations;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitDto;
import core.basesyntax.model.FruitStorage;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.Reader;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BuyOperationTest {
    private static final Integer EXPECTED_QUANTITY = 90;
    private static final String KEY = "banana";
    private static Operation buy;
    private static Reader reader = new Reader();

    @BeforeClass
    public static void beforeClass() {
        buy = new BuyOperation();
        FruitStorage.getFruitStorage().clear();
        OperationHandler.handleOperation(reader.readFromFile("src/main/resources/BuyTest.csv"));
    }

    @Test
    public void testBuyWithNormalData() {
        buy.doOperation(new FruitDto("b", KEY, "10", "2020-10-07"));
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

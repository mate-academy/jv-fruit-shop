package core.basesyntax.operation;

import core.basesyntax.OperationHandler;
import core.basesyntax.Storage;
import core.basesyntax.Transaction;
import core.basesyntax.csvservice.Reader;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BuyTest {
    private static final Integer EXPECTED_QUANTITY = 90;
    private static final String KEY = "banana";
    private static Operation buy;

    @BeforeClass
    public static void prepareEnvironmentBeforeTest() {
        buy = new Buy();
        Storage.storage.clear();
        OperationHandler.handleOperation(Reader.read("src/main/resources/buyTest.csv"));
    }

    @Test
    public void testBuyWithNormalData() {
        buy.provideOperation(
                new Transaction("b", KEY, "10", "2020-10-07"));
        Assert.assertEquals(EXPECTED_QUANTITY, Storage.storage.get(KEY).getAllQuantity());
    }

    @Test(expected = RuntimeException.class)
    public void testBuyWithRunOutOfFruits() {
        buy.provideOperation(
                new Transaction("b", KEY, "160", "2020-10-05"));
    }

    @Test(expected = RuntimeException.class)
    public void testBuyWithNonExistingFruit() {
        buy.provideOperation(
                new Transaction("b", "mango", "160", "2020-10-05"));
    }
}

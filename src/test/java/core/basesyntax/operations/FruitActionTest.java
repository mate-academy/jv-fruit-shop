package core.basesyntax.operations;

import core.basesyntax.service.CsvFileReaderImpl;
import core.basesyntax.storage.Storage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FruitActionTest {
    private static FruitAction act;
    private static final String SUPPLY = "s";
    private static final String BUY = "b";
    private static final String RETURN = "r";
    private static final String INCORRECT_OPERATION = "*";
    private static final String FRUIT = "banana";
    private static final Integer QUANTITY = 50;
    private static final Integer INCORRECT_QUANTITY = -5;
    private static final String DATE = "2020-09-15";

    @BeforeClass
    public static void beforeClass() {
        act = new FruitAction();
    }

    @Before
    public void before() {
        Storage.getStockBalance().clear();
    }

    @Test
    public void actionSupplyTest() {
        Assert.assertTrue(act.action(SUPPLY, FRUIT, QUANTITY, DATE));
    }

    @Test
    public void actionBuyTest() {
        Storage.addFruit(FRUIT, QUANTITY);
        Assert.assertTrue(act.action(BUY, FRUIT, QUANTITY, DATE));

    }

    @Test
    public void actionReturnTest() {
        Storage.addFruit(FRUIT, QUANTITY);
        Assert.assertTrue(act.action(RETURN, FRUIT, QUANTITY, DATE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkQuantityTest() {
        act.action(SUPPLY, FRUIT, INCORRECT_QUANTITY, DATE);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void soldOutFruitTest() {
        Assert.assertTrue(act.action(INCORRECT_OPERATION, FRUIT, QUANTITY, DATE));
    }
}

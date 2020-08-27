package core.basesyntax.operations;

import core.basesyntax.storage.Storage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BuyOperationTest {
    private static final Integer EXPECTED_QUANTITY = 20;
    private static final String KEY = "banana";
    private static final String NOT_AVAILABLE_KEY = "coconut";
    private static final String NORMAL_DATE = "2020-10-12";
    private static final String EXPIRY_DATE = "2020-05-12";
    private static final Integer QUANTITY = 50;
    private static final Integer SOLD_QUANTITY = 60;
    private static Buy buy;

    @BeforeClass
    public static void beforeClass() {
        buy = new BuyOperation();
    }

    @Before
    public void before() {
        Storage.addFruit("banana", QUANTITY);
    }

    @Test
    public void buyNormalTest() {
        buy.buyFruit(KEY, 30, NORMAL_DATE);
        Assert.assertEquals(EXPECTED_QUANTITY, Storage.getStockBalance().get(KEY));
    }

    @Test(expected = RuntimeException.class)
    public void soldOutFruitTest() {
        buy.buyFruit(KEY, SOLD_QUANTITY, NORMAL_DATE);
    }

    @Test(expected = RuntimeException.class)
    public void expirationDateTest() {
        buy.buyFruit(KEY, QUANTITY, EXPIRY_DATE);
    }

    @Test(expected = RuntimeException.class)
    public void notAvailableFruitTest() {
        buy.buyFruit(NOT_AVAILABLE_KEY, QUANTITY, NORMAL_DATE);
    }
}

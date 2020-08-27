package core.basesyntax.operations;

import core.basesyntax.storage.Storage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Map;

public class ReturnOperationTest {
    private static final Integer QUANTITY = 30;
    private static final Integer EXPECTED_QUANTITY = 60;
    private static final String INCORRECT_KEY = "banana";
    private static final String KEY = "orange";
    private static ReturnOperation ret;

    @BeforeClass
    public static void beforeClass() {
        ret = new ReturnOperation();
    }

    @Before
    public void before() {
        Storage.getStockBalance().clear();
        Storage.addFruit(KEY, QUANTITY);
    }

    @Test
    public void returnNormalTest() {
        Map<String, Integer> storage = Storage.getStockBalance();
        ret.returnFruit(KEY, QUANTITY);
        Assert.assertEquals(EXPECTED_QUANTITY, storage.get(KEY));
    }

    @Test(expected = RuntimeException.class)
    public void incorrectFruitTest() {
        ret.returnFruit(INCORRECT_KEY, QUANTITY);
    }
}

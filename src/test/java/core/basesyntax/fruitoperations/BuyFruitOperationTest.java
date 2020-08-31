package core.basesyntax.fruitoperations;

import core.basesyntax.model.FruitBatch;
import core.basesyntax.storage.Storage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;

public class BuyFruitOperationTest {
    private static final Storage TEST_STORAGE = new Storage();
    private static final BuyFruitOperation BUY_FRUIT_OPERATION = new BuyFruitOperation(TEST_STORAGE);
    private static final FruitBatch FRUIT_BATCH = new FruitBatch("b", "apple",
            10, LocalDate.parse("2020-05-17"));

    @BeforeClass
    public static void setUp() {
        TEST_STORAGE.addFruits(FRUIT_BATCH);
    }

    @Test
    public void nullApply() {
        try {
            BUY_FRUIT_OPERATION.apply(null);
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Cannot buy null", e.getMessage());
        }
    }

    @Test
    public void applyCorrect() {
        BUY_FRUIT_OPERATION.apply(FRUIT_BATCH);
        Assert.assertEquals("Storage size should be zero","apple, 0", TEST_STORAGE.outputProducts());
    }
}

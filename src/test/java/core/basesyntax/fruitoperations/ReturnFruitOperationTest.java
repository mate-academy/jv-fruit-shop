package core.basesyntax.fruitoperations;

import core.basesyntax.model.FruitBatch;
import core.basesyntax.storage.Storage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;

public class ReturnFruitOperationTest {
    private static final Storage TEST_STORAGE = new Storage();
    private static final ReturnFruitOperation RETURN_FRUIT_OPERATION = new ReturnFruitOperation(TEST_STORAGE);
    private static final FruitBatch FRUIT_BATCH = new FruitBatch("r", "apple",
            10, LocalDate.parse("2020-05-17"));

    @BeforeClass
    public static void setUp() {
        TEST_STORAGE.addFruits(FRUIT_BATCH);
    }

    @Test
    public void nullApply() {
        try {
            RETURN_FRUIT_OPERATION.apply(null);
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Cannot return null", e.getMessage());
        }
    }

    @Test
    public void applyCorrect() {
        RETURN_FRUIT_OPERATION.apply(FRUIT_BATCH);
        Assert.assertEquals("There should be 20 apples","apple, 20", TEST_STORAGE.outputProducts());
    }
}

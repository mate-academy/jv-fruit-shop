package core.basesyntax.fruitoperations;

import core.basesyntax.model.FruitBatch;
import core.basesyntax.storage.Storage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;

public class SupplyFruitOperationTest {
    private static final Storage TEST_STORAGE = new Storage();
    private static final SupplyFruitOperation SUPPLY_FRUIT_OPERATION = new SupplyFruitOperation(TEST_STORAGE);
    private static final FruitBatch FRUIT_BATCH = new FruitBatch("s", "apple",
            10, LocalDate.parse("2020-05-17"));

    @BeforeClass
    public static void setUp() {
        TEST_STORAGE.addFruits(FRUIT_BATCH);
    }

    @Test
    public void nullApply() {
        try {
            SUPPLY_FRUIT_OPERATION.apply(null);
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Cannot supply null", e.getMessage());
        }
    }

    @Test
    public void applyCorrect() {
        SUPPLY_FRUIT_OPERATION.apply(FRUIT_BATCH);
        Assert.assertEquals("There should be 20 apples","apple, 20\n", TEST_STORAGE.outputProducts());
    }
}
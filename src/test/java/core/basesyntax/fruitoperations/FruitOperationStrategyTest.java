package core.basesyntax.fruitoperations;

import core.basesyntax.model.FruitBatch;
import core.basesyntax.storage.Storage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class FruitOperationStrategyTest {
    private static final FruitBatch BUY_BATCH = new FruitBatch("b", "banana",
            10, LocalDate.parse("2020-05-17"));
    private static final FruitBatch RETURN_BATCH = new FruitBatch("r", "mango",
            10, LocalDate.parse("2020-05-17"));
    private static final FruitBatch SUPPLY_BATCH  = new FruitBatch("s", "apple",
            10, LocalDate.parse("2020-05-17"));
    private static final FruitBatch WRONG_OP_BATCH  = new FruitBatch("d", "apple",
            10, LocalDate.parse("2020-05-17"));
    private Storage storage;
    private FruitOperationStrategy strategy;


    @Before
    public void init() {
        FruitBatch placeholderBatch = new FruitBatch("b", "banana",
                100, LocalDate.parse("2020-05-17"));
        storage = new Storage();
        storage.addFruits(placeholderBatch);
        strategy = new FruitOperationStrategy(storage);
    }

    @Test
    public void returnBatch() {
        String expected = "banana, 100\nmango, 10\n";
        strategy.applyOperationOnBatch(RETURN_BATCH);
        Assert.assertEquals(expected, storage.outputProducts());
    }

    @Test
    public void buyBatch() {
        String expected = "banana, 90\n";
        strategy.applyOperationOnBatch(BUY_BATCH);
        Assert.assertEquals(expected, storage.outputProducts());
    }

    @Test
    public void supplyBatch() {
        String expected = "banana, 100\napple, 10\n";
        strategy.applyOperationOnBatch(SUPPLY_BATCH);
        Assert.assertEquals(expected, storage.outputProducts());
    }

    @Test
    public void incorrectOperationBatch() {
        try {
            strategy.applyOperationOnBatch(WRONG_OP_BATCH);
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("No such operation " + WRONG_OP_BATCH.getOperation(), e.getMessage());
        }

    }

}
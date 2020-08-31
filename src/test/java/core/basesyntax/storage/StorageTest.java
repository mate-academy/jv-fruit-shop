package core.basesyntax.storage;

import core.basesyntax.model.FruitBatch;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;

public class StorageTest {
    private static final Storage STORAGE_TO_REMOVE = new Storage();
    private static final Storage STORAGE_TO_ADD = new Storage();
    private static final Storage EMPTY_STORAGE = new Storage();
    private static final Storage STORAGE_FOR_OUTPUT = new Storage();
    private static final FruitBatch VALID_FRUIT = new FruitBatch("s", "apple",
            10, LocalDate.parse("2020-05-17"));
    private static final FruitBatch INVALID_FRUIT = new FruitBatch("s", "mango",
            15, LocalDate.parse("2020-05-20"));
    private static final FruitBatch[] OUTPUT_FRUITS = {new FruitBatch("s", "mango",
            15, LocalDate.parse("2020-05-20")), new FruitBatch("s", "banana",
            16, LocalDate.parse("2020-05-20"))};
    private static final FruitBatch[] FILLER_FRUITS = {new FruitBatch("s", "banana",
            15, LocalDate.parse("2020-05-20")), new FruitBatch("s", "apple",
            34, LocalDate.parse("2020-05-17"))};
    private static final String CORRECT_STRING = "banana, 16\nmango, 15";

    @BeforeClass
    public static void setUp() {
        STORAGE_TO_REMOVE.addFruits(FILLER_FRUITS[0]);
        STORAGE_TO_REMOVE.addFruits(FILLER_FRUITS[1]);
        STORAGE_FOR_OUTPUT.addFruits(OUTPUT_FRUITS[0]);
        STORAGE_FOR_OUTPUT.addFruits(OUTPUT_FRUITS[1]);

    }

    @Test
    public void removeNull() {
        try {
            STORAGE_TO_REMOVE.removeFruits(null);
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Cannot remove null fruit batch", e.getMessage());
        }
    }

    @Test
    public void removeNotAddedFruit() {
        boolean result = STORAGE_TO_REMOVE.removeFruits(INVALID_FRUIT);
        Assert.assertFalse("Result should be false",result);
    }

    @Test
    public void removeCorrect() {
        boolean result = STORAGE_TO_REMOVE.removeFruits(VALID_FRUIT);
        Assert.assertTrue("Result should be true", result);
    }

    @Test
    public void addNull() {
        try {
            STORAGE_TO_ADD.addFruits(null);
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Cannot add null fruit batch", e.getMessage());
        }
    }

    @Test
    public void addNewFruit() {
        boolean result = STORAGE_TO_ADD.addFruits(VALID_FRUIT);
        Assert.assertTrue(result);
    }

    @Test
    public void addExistingFruit() {
        STORAGE_TO_ADD.addFruits(VALID_FRUIT);
        boolean result = STORAGE_TO_ADD.addFruits(VALID_FRUIT);
        Assert.assertTrue(result);
    }

    @Test
    public void sizeOfEmptyStorage() {
        int result = EMPTY_STORAGE.getStorageSize();
        Assert.assertEquals("Size should be zero", 0, result);
    }

    @Test
    public void printEmptyStorage() {
        String result = EMPTY_STORAGE.outputProducts();
        Assert.assertEquals("Output string should be empty", "", result);
    }

    @Test
    public void printCorrect() {
        String result = STORAGE_FOR_OUTPUT.outputProducts();
        Assert.assertEquals("Outputs should be equal", CORRECT_STRING, result);
    }

}

package core.basesyntax;

import core.basesyntax.service.FruitFileReader;
import core.basesyntax.service.Operation;
import core.basesyntax.service.Storage;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class StorageTest {
    private FruitFileReader reader = new FruitFileReader();
    private List<Operation> operations;

    @Test
    public void testPerfectData() {
        operations = reader.readOperation("src/PerfectData.csv");
        Storage storage = new Storage();
        storage.addFruits(operations);
        Assert.assertEquals(97, storage.getAmount("banana"));
    }

    @Test
    public void testWrongReturnDate() {
        operations = reader.readOperation("src/WrongReturnDate.csv");
        Storage storage = new Storage();
        storage.addFruits(operations);
        Assert.assertEquals(80, storage.getAmount("banana"));
    }

    @Test
    public void testDifferentFruits() {
        operations = reader.readOperation("src/DifferentFruits.csv");
        Storage storage = new Storage();
        storage.addFruits(operations);
        Assert.assertEquals(85, storage.getAmount("banana"));
        Assert.assertEquals(80, storage.getAmount("apple"));
    }

    @Test(expected = RuntimeException.class)
    public void testNotEnoughAmountIfFruit(){
        operations = reader.readOperation("src/NotEnoughAmount.csv");
        Storage storage = new Storage();
        storage.addFruits(operations);
    }

    @Test(expected = RuntimeException.class)
    public void testNonExistingFruit(){
        operations = reader.readOperation("src/NonExistingFruit.csv");
        Storage storage = new Storage();
        storage.addFruits(operations);
    }
}
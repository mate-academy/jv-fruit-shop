package core.basesyntax;

import core.basesyntax.service.FruitFileReader;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.Operation;
import core.basesyntax.service.Storage;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class StorageTest {
    private FruitService service = new FruitService();
    private FruitFileReader reader = new FruitFileReader();
    private List<Operation> operations;

    @Test
    public void testPerfectData() {
        operations = service.parseOperations(reader.readFruitFile("src/PerfectData.csv"));
        Storage storage = new Storage();
        storage.addFruits(operations);
        Assert.assertEquals(97, storage.getAmount("banana"));
    }

    @Test
    public void testWrongReturnDate() {
        operations = service.parseOperations(reader.readFruitFile("src/WrongReturnDate.csv"));
        Storage storage = new Storage();
        storage.addFruits(operations);
        Assert.assertEquals(80, storage.getAmount("banana"));
    }

    @Test
    public void testDifferentFruits(){
        operations = service.parseOperations(reader.readFruitFile("src/DifferentFruits.csv"));
        Storage storage = new Storage();
        storage.addFruits(operations);
        Assert.assertEquals(85, storage.getAmount("banana"));
        Assert.assertEquals(80, storage.getAmount("apple"));
    }

    @Test(expected = RuntimeException.class)
    public void testNotEnoughAmountIfFruit(){
        operations = service.parseOperations(reader.readFruitFile("src/NotEnoughAmount.csv"));
        Storage storage = new Storage();
        storage.addFruits(operations);
    }

    @Test(expected = RuntimeException.class)
    public void testNonExistingFruit(){
        operations = service.parseOperations(reader.readFruitFile("src/NonExistingFruit.csv"));
        Storage storage = new Storage();
        storage.addFruits(operations);
    }

    @Test
    public void testWithoutReturn(){
        operations = service.parseOperations(reader.readFruitFile("src/TestWithoutReturn.csv"));
        Storage storage = new Storage();
        storage.addFruits(operations);
        Assert.assertEquals(90, storage.getAmount("banana"));
    }
}

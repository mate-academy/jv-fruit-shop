package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.List;

public class FruitStorageTest {
    private List<FruitOperation> operations;
    private static FruitFileReader reader;

    @BeforeClass
    public static void setReader() {
        reader = new FruitFileReader();
    }

    @Test
    public void testWrongReturnDate() {
        operations = reader.readOperation("src/main/resources/WrongDate.csv");
        FruitStorage fruitStorage = new FruitStorage();
        fruitStorage.add(operations);
        Assert.assertEquals(120, fruitStorage.getQuantity("banana"));
    }

    @Test
    public void testForInput() {
        operations = reader.readOperation("src/main/resources/Input.csv");
        FruitStorage fruitStorage = new FruitStorage();
        fruitStorage.add(operations);
        Assert.assertEquals(85, fruitStorage.getQuantity("banana"));
    }

    @Test(expected = RuntimeException.class)
    public void testNotEnoughQuantityIfFruit(){
        operations = reader.readOperation("src/main/resources/NotEnoughAmount.csv");
        FruitStorage fruitStorage = new FruitStorage();
        fruitStorage.add(operations);
    }

    @Test(expected = RuntimeException.class)
    public void testNonExistingFruit(){
        operations = reader.readOperation("src/main/resources/NonExistingFruit.csv");
        FruitStorage fruitStorage = new FruitStorage();
        fruitStorage.add(operations);
    }

    @Test
    public void testDifferentFruits() {
        operations = reader.readOperation("src/main/resources/Different.csv");
        FruitStorage fruitStorage = new FruitStorage();
        fruitStorage.add(operations);
        Assert.assertEquals(85, fruitStorage.getQuantity("banana"));
        Assert.assertEquals(200, fruitStorage.getQuantity("apple"));
    }
}
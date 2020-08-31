package core.basesyntax;

import core.basesyntax.service.impl.SupplyOrReturnOperation;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;

public class SupplyOrReturnOperationTest {

    private static SupplyOrReturnOperation operation;
    private static FruitStorage fruitStorage;
    private static Fruit fruit;

    @BeforeClass
    public static void createFruitAndStorage() {
        fruitStorage = new FruitStorage();
        operation = new SupplyOrReturnOperation(fruitStorage);
        fruit = new Fruit();
        fruit.setName("banana");
        fruit.setDate(LocalDate.parse("2020-10-17"));
    }

    @Test
    public void applyOK() {
        int actual = fruitStorage.getListOfFruits().size();
        Assert.assertEquals(0, actual);
        operation.apply(fruit);
        actual = fruitStorage.getListOfFruits().size();
        Assert.assertEquals(1, actual);
    }
}

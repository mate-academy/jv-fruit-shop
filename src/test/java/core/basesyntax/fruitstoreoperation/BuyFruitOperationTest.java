package core.basesyntax.fruitstoreoperation;

import core.basesyntax.Storage;
import core.basesyntax.exception.NoSuchFruitException;
import core.basesyntax.model.InputDataModel;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.time.LocalDate;

public class BuyFruitOperationTest {
    private static Storage storage;
    private static FruitStoreOperation operation;
    private InputDataModel dataModel;
    private String name;
    private LocalDate date;
    private int amount;
    private int buyAmount;

    @BeforeClass
    public static void beforeClass() {
        storage = new Storage();
        operation = new BuyFruitOperation();
    }

    @After
    public void tearDown() {
        storage.throwAwayAllTheFruits();
    }

    @Test
    public void buyFruitOk() {
        name = "banana";
        date = LocalDate.now();
        dataModel = new InputDataModel(name, date);
        amount = 100;
        buyAmount = 50;
        storage.addFruitProduct(dataModel, amount);
        operation.doOperation(dataModel, buyAmount);
        Assert.assertEquals(amount - buyAmount,
                storage.getAllFruits().get(dataModel).intValue());
    }

    @Test(expected = NoSuchFruitException.class)
    public void buyExpiredFruit() {
        name = "banana";
        date = LocalDate.now().minusDays(1);
        dataModel = new InputDataModel(name, date);
        amount = 100;
        buyAmount = 50;
        storage.addFruitProduct(dataModel, amount);
        operation.doOperation(dataModel, buyAmount);
    }
}

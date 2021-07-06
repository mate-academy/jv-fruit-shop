package core.basesyntax.fruitstoreoperation;

import core.basesyntax.Storage;
import core.basesyntax.model.InputDataModel;
import org.junit.*;

import java.time.LocalDate;

public class SupplyFruitOperationTest {
    private static Storage storage;
    private static FruitStoreOperation operation;
    private InputDataModel dataModel;
    private String name;
    private LocalDate date;
    private int amount;

    @BeforeClass
    public static void beforeClass() {
        storage = new Storage();
        operation = new SupplyFruitOperation();
    }

    @Before
    public void setUp(){
        storage.throwAwayAllTheFruits();
    }

    @After
    public void tearDown() {
        storage.throwAwayAllTheFruits();
    }

    @Test
    public void supplyFruitOk() {
        name = "banana";
        date = LocalDate.now();
        dataModel = new InputDataModel(name, date);
        amount = 100;
        operation.doOperation(dataModel, amount);
        Assert.assertTrue(storage.getAllFruits().containsKey(dataModel));
        Assert.assertEquals(amount, storage.getAllFruits().get(dataModel).intValue());
    }
}

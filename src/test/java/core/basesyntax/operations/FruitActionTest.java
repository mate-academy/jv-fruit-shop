package core.basesyntax.operations;

import core.basesyntax.service.Transaction;
import core.basesyntax.storage.Storage;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class FruitActionTest {
    private static FruitAction act;
    private static final String SUPPLY = "s";
    private static final String BUY = "b";
    private static final String RETURN = "r";
    private static final String INCORRECT_OPERATION = "*";
    private static final String FRUIT = "banana";
    private static final String QUANTITY = "50";
    private static final Integer QUANTITY_INT = 100;
    private static final Integer INCORRECT_QUANTITY = -5;
    private static final String DATE = "2020-09-15";
    List<String> testList;

    @BeforeClass
    public static void beforeClass() {
        act = new FruitAction();
    }

    @Before
    public void before() {
        testList = new ArrayList<>();
        testList.add(0, SUPPLY);
        testList.add(1, FRUIT);
        testList.add(2, QUANTITY);
        testList.add(3, DATE);
    }

    @After
    public void after(){
        Storage.getStockBalance().clear();
    }

    @Test
    public void actionSupplyTest() {
        Transaction transaction = new Transaction(testList);
        Assert.assertTrue(act.action(transaction));
    }

    @Test
    public void actionBuyTest() {
        Storage.addFruit(FRUIT, QUANTITY_INT);
        Transaction transaction = new Transaction(testList);
        transaction.setOperation(BUY);
        Assert.assertTrue(act.action(transaction));
    }

    @Test
    public void actionReturnTest() {
        Storage.addFruit(FRUIT, QUANTITY_INT);
        Transaction transaction = new Transaction(testList);
        transaction.setOperation(RETURN);
        Assert.assertTrue(act.action(transaction));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkQuantityTest() {
        Storage.addFruit(FRUIT, QUANTITY_INT);
        Transaction transaction = new Transaction(testList);
        transaction.setQuantity(INCORRECT_QUANTITY);
        act.action(transaction);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void soldOutFruitTest() {
        Storage.addFruit(FRUIT, QUANTITY_INT);
        Transaction transaction = new Transaction(testList);
        transaction.setOperation(INCORRECT_OPERATION);
        act.action(transaction);
    }
}

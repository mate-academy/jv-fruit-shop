package core.basesyntax;

import core.basesyntax.exception.NotEnoughFruitException;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FruitServiceTest {
    private static List<Transaction> testTransactionsOk;
    private static List<Transaction> testTransactionsExpDate;
    private FruitService fruitService;
    private FruitStorage fruitStorage;

    @BeforeClass
    public static void beforeClass() {
        Transaction transactionOne = new Transaction(
                Operation.SUPPLY, "banana", 100, LocalDate.of(2020, 10, 17));
        Transaction transactionTwo = new Transaction(
                Operation.BUY, "banana", 20, LocalDate.of(2020, 10, 15));
        Transaction transactionThree = new Transaction(
                Operation.RETURN, "banana", 5, LocalDate.of(2020, 10, 17));
        Transaction transactionFour = new Transaction(
                Operation.SUPPLY, "apple", 200, LocalDate.of(2020, 10, 17));
        Transaction transactionFive = new Transaction(
                Operation.BUY, "apple", 50, LocalDate.of(2020, 10, 15));
        testTransactionsOk = List.of(transactionOne, transactionTwo, transactionThree,
                transactionFour, transactionFive);
        Transaction transactionFiveExpDate = new Transaction(
                Operation.SUPPLY, "apple", 20, LocalDate.of(2020, 10, 20));
        Transaction transactionSixExpDate = new Transaction(
                Operation.BUY, "apple", 30, LocalDate.of(2020, 10, 20));
        testTransactionsExpDate = List.of(transactionOne, transactionTwo, transactionThree,
                transactionFour, transactionFiveExpDate, transactionSixExpDate);
    }

    @Before
    public void setUp() {
        fruitStorage = new FruitStorage();
        fruitService = new FruitService(fruitStorage);
    }

    @Test
    public void fillFruitStorage_ok() {
        fruitService.fillFruitStorage(testTransactionsOk);
        Map<String, Integer> stock = fruitStorage.getStockBalance();
        Assert.assertEquals(2, stock.size());
        Assert.assertEquals(85, (int) stock.get("banana"));
        Assert.assertEquals(150, (int)stock.get("apple"));
    }

    @Test
    public void fillFruitStorage_expDate() {
        try {
            fruitService.fillFruitStorage(testTransactionsExpDate);
            Assert.fail("Expected NotEnoughFruitException");
        } catch (NotEnoughFruitException e) {
            Assert.assertEquals("Asked to buy 30 apple, but have 20", e.getMessage());
        }
    }

    @Test
    public void fillFruitStorage_empty() {
        fruitService.fillFruitStorage(Collections.emptyList());
        Map<String, Integer> stock = fruitStorage.getStockBalance();
        Assert.assertEquals(0, stock.size());
    }
}

package core.basesyntax;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FruitServiceTest {
    private static List<Transaction> testTransactionsOk;
    private static List<Transaction> testTransactionsNegativeValue;
    private static FruitService fruitService;

    @BeforeClass
    public static void beforeClass() {
        fruitService = new FruitService();
        Transaction transactionOne = new Transaction(Operation.SUPPLY, "banana", 100);
        Transaction transactionTwo = new Transaction(Operation.BUY, "banana", 20);
        Transaction transactionThree = new Transaction(Operation.RETURN, "banana", 5);
        Transaction transactionFour = new Transaction(Operation.SUPPLY, "apple", 200);
        Transaction transactionFive = new Transaction(Operation.BUY, "apple", 50);
        testTransactionsOk = List.of(transactionOne, transactionTwo, transactionThree,
                transactionFour, transactionFive);
        Transaction transactionFiveNegative = new Transaction(Operation.BUY, "apple", 300);
        testTransactionsNegativeValue = List.of(transactionOne, transactionTwo, transactionThree,
                transactionFour, transactionFiveNegative);
    }

    @Test
    public void getStockBalance_ok() {
        Map<String, Integer> result = fruitService.getStockBalance(testTransactionsOk);
        Assert.assertEquals(2, result.size());
        Assert.assertEquals(85, (int)result.get("banana"));
        Assert.assertEquals(150, (int)result.get("apple"));
    }

    @Test
    public void getStockBalance_negativeValue() {
        Map<String, Integer> result = fruitService.getStockBalance(testTransactionsNegativeValue);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(85, (int)result.get("banana"));
    }

    @Test
    public void getStockBalance_empty() {
        Map<String, Integer> result = fruitService.getStockBalance(Collections.emptyList());
        Assert.assertEquals(0, result.size());
    }
}

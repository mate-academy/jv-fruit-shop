package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TransactionMapperImplTest {
    private static TransactionMapper transactionMapper;
    private static List<String> fromFileReaderNegative;
    private static List<Transaction> expectedResult;
    private static List<String> sourceTransactions;
    private static List<String> reportFromStorage;

    @BeforeClass
    public static void beforeClass() throws Exception {
        transactionMapper = new TransactionMapperImpl();
        fromFileReaderNegative = Arrays.asList("b,apple,-10");

        expectedResult = Arrays.asList(
                new Transaction(Operation.BALANCE, new Fruit("apple"), 100),
                new Transaction(Operation.PURCHASE, new Fruit("apple"), 200),
                new Transaction(Operation.BALANCE, new Fruit("banana"), 300),
                new Transaction(Operation.SUPPLY, new Fruit("banana"), 500)
        );

        sourceTransactions = Arrays.asList(
                "b,apple,100",
                "p,apple,200",
                "b,banana,300",
                "s,banana,500"
        );

        reportFromStorage = Arrays.asList(
                "apple, 600",
                "banana, 700",
                "orange, 800"
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNegativeQuantity_expectException() {
        transactionMapper.stringsToTransactions(fromFileReaderNegative);
    }

    @Test
    public void whenConvertFromStringsToTransactions_expectedTransactionList() {
        List<Transaction> actualList = transactionMapper.stringsToTransactions(sourceTransactions);
        Assert.assertEquals(expectedResult, actualList);
    }

    @Before
    public void setUp() throws Exception {
        Storage.fruitStorage.put(new Fruit("apple"), 600);
        Storage.fruitStorage.put(new Fruit("banana"), 700);
        Storage.fruitStorage.put(new Fruit("orange"), 800);
    }

    @Test
    public void whenStorageToStrings_expectedStringsList() {
        List<String> actual = transactionMapper.storageToStrings(Storage.fruitStorage);
        Assert.assertEquals(reportFromStorage, actual);
    }

    @After
    public void tearDown() throws Exception {
        Storage.fruitStorage.clear();
    }
}

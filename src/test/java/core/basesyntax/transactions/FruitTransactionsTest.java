package core.basesyntax.transactions;

import core.basesyntax.service.CsvFileReaderImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FruitTransactionsTest {
    private static FruitTransactions transactions;
    private static CsvFileReaderImpl fileReader;

    @BeforeClass
    public static void beforeClass() {
        String path = "src\\main\\resources\\fruits.csv";
        fileReader = new CsvFileReaderImpl();
        transactions = new FruitTransactions(fileReader.readFile(path));
    }

    @Test
    public void fruitTransactionNormalTest() {
        String path = "src\\main\\resources\\fruits.csv";
        Assert.assertEquals(transactions.getTransactions(), fileReader.readFile(path));
    }
}

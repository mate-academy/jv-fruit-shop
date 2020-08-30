package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.TransactionReader;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.List;

public class TransactionReaderTest {
    private static final String WRONG_PATH = "src/test/resources/data1.csv";
    private static final String REFERENCE_FILE = "src/test/resources/data.csv";
    private static final String EMPTY_FILE_PATH = "src/test/resources/empty.csv";
    private static TransactionReader scanner;

    @BeforeClass
    public static void setTransactionScanner() {
        scanner = new TransactionReader();
    }

    @Test
    public void getTransactionListOK() {
        List<Transaction> transactions = scanner.getTransactionList(REFERENCE_FILE);
        Assert.assertFalse(transactions.isEmpty());
    }

    @Test
    public void getEmptyTransactionList() {
        List<Transaction> transactions = scanner.getTransactionList(EMPTY_FILE_PATH);
        Assert.assertTrue(transactions.isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void getWrongFilePath() {
        scanner.getTransactionList(WRONG_PATH);
    }
}

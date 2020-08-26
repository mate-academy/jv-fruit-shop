package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class TransactionScannerTest {
    public static final String REFERENCE_FILE = "src/test/resources/data.csv";
    public static final String WRONG_PATH = "src/test/resources/data1.csv";
    public static final String EMPTY_FILE_PATH = "src/test/resources/empty.csv";
    public static final String WRONG_FILE_PATH = "src/test/resources/wrong.csv";
    public static final Path GENERATED_PATH = Path.of("src/test/out/test.csv");

    @Test
    public void getTransactionListOK() {
        TransactionScanner scanner = new TransactionScanner();
        List<Transaction> transactions = scanner.transactionList(REFERENCE_FILE);
        Assert.assertFalse(transactions.isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void getWrongFilePath() {
        TransactionScanner scanner = new TransactionScanner();
        scanner.transactionList(WRONG_PATH);
    }

    @Test
    public void getCalculatorOK() {
        DataExecutor executor = new DataExecutor();
        Map<String, Integer> map = executor.dataExecutor(REFERENCE_FILE);
        Assert.assertFalse(map.isEmpty());
    }

    @Test
    public void getEmptyCalculator() {
        DataExecutor executor = new DataExecutor();
        Map<String, Integer> map = executor.dataExecutor(EMPTY_FILE_PATH);
        Assert.assertTrue(map.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getBuyBeforeSupply() {
        DataExecutor executor = new DataExecutor();
        executor.dataExecutor(WRONG_FILE_PATH);
    }

    @Test
    public void getResultOK() {
        DataWriter dataWriter = new DataWriter();
        String report = dataWriter.getReport(REFERENCE_FILE);
        Assert.assertEquals("fruit;quantity\n" +
                "banana;77\n" +
                "orange;105\n" +
                "apple;557", report );
    }

    @Test
    public void getEmptyResult() {
        DataWriter dataWriter = new DataWriter();
        String report = dataWriter.getReport(EMPTY_FILE_PATH);
        Assert.assertEquals("", report);
    }

    @Test
    public void getFileExist() {
        DataWriter dataWriter = new DataWriter();
        dataWriter.getReport(REFERENCE_FILE);
        Assert.assertTrue(Files.exists(GENERATED_PATH));
    }

}

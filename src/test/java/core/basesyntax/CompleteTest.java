package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.ReportWriter;
import core.basesyntax.service.TransactionReader;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CompleteTest {
    public static final String REFERENCE_FILE = "src/test/resources/data.csv";
    public static final String WRONG_PATH = "src/test/resources/data1.csv";
    public static final String EMPTY_FILE_PATH = "src/test/resources/empty.csv";
    public static final String WRONG_FILE_PATH = "src/test/resources/wrong.csv";
    public static final String NOT_ENOUGH_ITEMS = "src/test/resources/not_enough.csv";
    public static final String NO_FRESH_ITEMS = "src/test/resources/no_fresh.csv";
    public static final String SINGLE_FRUIT = "src/test/resources/single_fruit.csv";
    public static final Path GENERATED_PATH = Path.of("src/test/out/test.csv");

    @Test
    public void getTransactionListOK() {
        TransactionReader scanner = new TransactionReader();
        List<Transaction> transactions = scanner.getTransactionList(REFERENCE_FILE);
        Assert.assertFalse(transactions.isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void getWrongFilePath() {
        TransactionReader scanner = new TransactionReader();
        scanner.getTransactionList(WRONG_PATH);
    }

//    @Test
//    public void getCalculatorOK() {
//        DataExecutor executor = new DataExecutor();
//        executor.dataExecutor(REFERENCE_FILE);
//        List<String> report = executor.printReport();
//        Assert.assertEquals(report, );
//    }

//    @Test
//    public void getEmptyCalculator() {
//        DataExecutor executor = new DataExecutor();
//        executor.dataExecutor(EMPTY_FILE_PATH);
//        Assert.assertTrue(map.isEmpty());
//    }

    @Test(expected = RuntimeException.class)
    public void getBuyBeforeSupply() {
        StorageService executor = new StorageService();
        executor.storageWriter(WRONG_FILE_PATH);
    }

    @Test
    public void getResultOK() {
        ReportWriter reportWriter = new ReportWriter();
        String report = reportWriter.getReport(REFERENCE_FILE);
        Assert.assertEquals("fruit,quantity\n" +
                "banana,77\n" +
                "orange,105\n" +
                "apple,557", report );
    }

    @Test
    public void getSingleFruit() {
        ReportWriter reportWriter = new ReportWriter();
        String report = reportWriter.getReport(SINGLE_FRUIT);
        Assert.assertEquals("fruit,quantity\n" +
                "banana,90", report);
    }

    @Test
    public void getEmptyResult() {
        ReportWriter reportWriter = new ReportWriter();
        String report = reportWriter.getReport(EMPTY_FILE_PATH);
        Assert.assertEquals("fruit,quantity", report);
    }

    @Test
    public void getFileExist() {
        ReportWriter reportWriter = new ReportWriter();
        reportWriter.getReport(REFERENCE_FILE);
        Assert.assertTrue(Files.exists(GENERATED_PATH));
    }

    @Test(expected = RuntimeException.class)
    public void notEnoughItems() {
        StorageService executor = new StorageService();
        executor.storageWriter(NOT_ENOUGH_ITEMS);
    }

    @Test(expected = RuntimeException.class)
    public void noFreshFood() {
        StorageService executor = new StorageService();
        executor.storageWriter(NO_FRESH_ITEMS);
    }
}

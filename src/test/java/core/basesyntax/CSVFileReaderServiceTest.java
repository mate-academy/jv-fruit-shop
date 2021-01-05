package core.basesyntax;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.impl.CSVFileReaderService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CSVFileReaderServiceTest {
    private static final String MONDAY = "src/test/resources/data_for_monday.csv";
    private static final String TUESDAY = "src/test/resources/data_for_tuesday.csv";
    private static final String WEDNESDAY = "src/test/resources/data_for_wednesday.csv";
    private static final String THURSDAY = "src/test/resources/data_for_thursday.csv";
    private static final String FRIDAY = "src/test/resources/data_for_friday.csv";
    private static final String SATURDAY = "src/test/resources/data_for_saturday.csv";
    private static final String SUNDAY = "src/test/resources/data_for_sunday.csv";
    private static CSVFileReaderService csvFileReaderService;

    @BeforeClass
    public static void beforeAll() {
        csvFileReaderService = new CSVFileReaderService();
    }

    @Test
    public void readFromFile_Ok() {
        Fruit BANANA = new Fruit("banana");
        Fruit APPLE = new Fruit("apple");
        List<Transaction> expected = new ArrayList<>();
        expected.add(new Transaction(Operation.BALANCE, BANANA, 20));
        expected.add(new Transaction(Operation.BALANCE, APPLE, 100));
        expected.add(new Transaction(Operation.SUPPLY, BANANA, 100));
        expected.add(new Transaction(Operation.PURCHASE, BANANA, 13));
        expected.add(new Transaction(Operation.RETURN, APPLE, 10));
        expected.add(new Transaction(Operation.PURCHASE, APPLE, 20));
        expected.add(new Transaction(Operation.PURCHASE, BANANA, 5));
        expected.add(new Transaction(Operation.SUPPLY, BANANA, 50));
        List<Transaction> actual = csvFileReaderService.readFromFile(MONDAY);
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test(expected = RuntimeException.class)
    public void readFromFileNegativeQuantity_NotOk() {
        csvFileReaderService.readFromFile(TUESDAY);
    }

    @Test(expected = RuntimeException.class)
    public void readFromFileBigPurchaseQuantity_NotOk() {
        csvFileReaderService.readFromFile(WEDNESDAY);
    }

    @Test(expected = RuntimeException.class)
    public void readFromFileInvalidOperation_NotOk() {
        csvFileReaderService.readFromFile(FRIDAY);
    }

    @Test(expected = RuntimeException.class)
    public void readFromFileEmptyQuantity_NotOk() {
        csvFileReaderService.readFromFile(THURSDAY);
    }

    @Test(expected = RuntimeException.class)
    public void readFromFileBalanceInTheMiddle_NotOk() {
        csvFileReaderService.readFromFile(SATURDAY);
    }

    @Test(expected = RuntimeException.class)
    public void readFromFileIncorrectInputFile_NotOk() {
        csvFileReaderService.readFromFile(SUNDAY);
    }
}
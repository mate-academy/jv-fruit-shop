package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.FileReaderService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvFileReaderServiceTest {
    private static final String MONDAY = "src/test/resources/data_for_monday.csv";
    private static final String THURSDAY = "src/test/resources/data_for_thursday.csv";
    private static final String FRIDAY = "src/test/resources/data_for_friday.csv";
    private static final String SATURDAY = "src/test/resources/data_for_saturday.csv";
    private static final String SUNDAY = "src/test/resources/data_for_sunday.csv";
    private static FileReaderService csvFileReaderService;

    @BeforeClass
    public static void beforeAll() {
        csvFileReaderService = new CsvFileReaderService();
    }

    @Test
    public void readFromFile_Ok() {
        Fruit banana = new Fruit("banana");
        Fruit apple = new Fruit("apple");
        List<Transaction> expected = new ArrayList<>();
        expected.add(new Transaction(Operation.BALANCE, banana, 20));
        expected.add(new Transaction(Operation.BALANCE, apple, 100));
        expected.add(new Transaction(Operation.SUPPLY, banana, 100));
        expected.add(new Transaction(Operation.PURCHASE, banana, 13));
        expected.add(new Transaction(Operation.RETURN, apple, 10));
        expected.add(new Transaction(Operation.PURCHASE, apple, 20));
        expected.add(new Transaction(Operation.PURCHASE, banana, 5));
        expected.add(new Transaction(Operation.SUPPLY, banana, 50));
        List<Transaction> actual = csvFileReaderService.readFromFile(MONDAY);
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
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

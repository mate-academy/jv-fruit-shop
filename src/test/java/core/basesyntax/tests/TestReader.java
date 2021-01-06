package core.basesyntax.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.impl.CsvFileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.Test;

public class TestReader {
    private static final String FILE_PATH_ONE_LINE =
            "src/main/resourcestests/fruitShopOneLine.csv";
    private static final String FILE_PATH_FOUR_LINES =
            "src/main/resourcestests/fruitShopFourLines.csv";
    private static final String FILE_PATH_WITH_ERROR =
            "src/main/resourcestests/fruitShopNotAllowedOperation.csv";
    private static List<TransactionDto> data;
    private static final FileReader reader = new CsvFileReader();

    @After
    public void cleanData() {
        if (data != null) {
            data.clear();
        }
    }

    @Test
    public void checkReadOneLine() {
        List<TransactionDto> expected = new ArrayList<>();
        expected.add(new TransactionDto(Operation.BALANCE, new Fruit("banana"), 20));
        data = reader.readData(FILE_PATH_ONE_LINE);
        assertEquals(expected.size(), data.size(), "Size list must be equals");
        assertEquals(expected, data, "List must be equals");
    }

    @Test
    public void checkReadFourLines() {
        List<TransactionDto> expected = new ArrayList<>();
        Fruit banana = new Fruit("banana");
        expected.add(new TransactionDto(Operation.BALANCE, banana, 20));
        expected.add(new TransactionDto(Operation.RETURN, banana, 100));
        expected.add(new TransactionDto(Operation.SUPPLY, banana, 100));
        expected.add(new TransactionDto(Operation.PURCHASE, banana, 13));
        data = reader.readData(FILE_PATH_FOUR_LINES);
        assertEquals(expected.size(), data.size(), "Size list must be equals");
        assertEquals(expected, data, "List must be equals");
    }

    @Test
    public void notEquals() {
        List<TransactionDto> expected = new ArrayList<>();
        Fruit banana = new Fruit("banana");
        expected.add(new TransactionDto(Operation.BALANCE, banana, 20));
        expected.add(new TransactionDto(Operation.RETURN, banana, 100));
        expected.add(new TransactionDto(Operation.SUPPLY, banana, 100));
        expected.add(new TransactionDto(Operation.PURCHASE, banana, 13));
        expected.add(new TransactionDto(Operation.RETURN, banana, 20));
        data = reader.readData(FILE_PATH_FOUR_LINES);
        assertNotEquals(expected.size(), data.size(), "Size list must be not equal");
        assertNotEquals(expected, data, "List must be not equal");
    }

    @Test(expected = RuntimeException.class)
    public void fileNotFound() {
        data = reader.readData("path");
    }

    @Test(expected = NoSuchElementException.class)
    public void notAllowedOperation() {
        List<TransactionDto> expected = new ArrayList<>();
        Fruit banana = new Fruit("banana");
        expected.add(new TransactionDto(Operation.BALANCE, banana, 20));
        expected.add(new TransactionDto(Operation.RETURN, banana, 100));
        expected.add(new TransactionDto(Operation.SUPPLY, banana, 100));
        expected.add(new TransactionDto(Operation.PURCHASE, banana, 13));
        data = reader.readData(FILE_PATH_WITH_ERROR);
    }
}


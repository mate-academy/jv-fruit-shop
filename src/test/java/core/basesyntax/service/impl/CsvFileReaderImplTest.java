package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.CsvFileReader;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CsvFileReaderImplTest {
    private CsvFileReader csvFileReader;

    @Before
    public void setUp() {
        csvFileReader = new CsvFileReaderImpl();
    }

    @Test(expected = RuntimeException.class)
    public void correctQuality_notOk() {
        String filePath = "src/test/resources/incorrectQuality_fruit_shop.csv";
        csvFileReader.readFromFile(filePath);
    }

    @Test(expected = RuntimeException.class)
    public void correctOperation_notOk() {
        String filePath = "src/test/resources/incorrectOperation_fruit_shop.csv";
        csvFileReader.readFromFile(filePath);
    }

    @Test
    public void readCsvFile_Ok() {
        String filePath = "src/test/resources/correct_fruit_shop.csv";
        List<TransactionDto> expectedTransactionDtoList =
                List.of(new TransactionDto(Operation.BALANCE, new Fruit("banana"), 20),
                        new TransactionDto(Operation.BALANCE, new Fruit("apple"), 100),
                        new TransactionDto(Operation.PURCHASE, new Fruit("banana"), 13),
                        new TransactionDto(Operation.RETURN, new Fruit("apple"), 10),
                        new TransactionDto(Operation.SUPPLY, new Fruit("apple"), 20));

        List<TransactionDto> actualTransactionDtoList = csvFileReader.readFromFile(filePath);
        Assert.assertEquals(expectedTransactionDtoList, actualTransactionDtoList);
    }
}


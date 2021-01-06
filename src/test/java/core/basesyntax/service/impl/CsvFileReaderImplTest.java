package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.CsvFileReader;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class CsvFileReaderImplTest {
    CsvFileReader csvFileReader = new CsvFileReaderImpl();

    @Test
    public void rightFileReaderImpl() {
        CsvFileReader csvFileReader = new CsvFileReaderImpl();
        List<TransactionDto> transactionDto = csvFileReader
                .readFile("src/test/resources/test-read.csv");
        Assert.assertEquals(4, transactionDto.size());
    }

    @Test(expected = RuntimeException.class)
    public void wrongFileReaderImpl() {
        List<TransactionDto> transactionDto = csvFileReader
                .readFile("src/main/resources/read.csv");
    }

    @Test
    public void readFile_Ok() {
        List<TransactionDto> expected =
                List.of(new TransactionDto(Operation.BALANCE, new Fruit("banana"), 20),
                        new TransactionDto(Operation.BALANCE, new Fruit("apple"), 40),
                        new TransactionDto(Operation.PURCHASE, new Fruit("banana"), 50),
                        new TransactionDto(Operation.SUPPLY, new Fruit("banana"), 10));

        CsvFileReader fileReader = new CsvFileReaderImpl();
        List<TransactionDto> actual = fileReader
                .readFile("src/test/resources/test-read.csv");
        Assert.assertEquals(expected, actual);
    }
}

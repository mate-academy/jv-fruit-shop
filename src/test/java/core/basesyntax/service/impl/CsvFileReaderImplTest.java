package core.basesyntax.service.impl;

import core.basesyntax.model.TransactionDto;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class CsvFileReaderImplTest {
    CsvFileReaderImpl reader = new CsvFileReaderImpl();

    @Test
    public void correctCvsFileReaderImpl() {
        List<TransactionDto> transactionDtos = reader
                .readData("src/test/resources/test-fruit-correct.csv");
        Assert.assertEquals(3, transactionDtos.size());
    }

    @Test(expected = RuntimeException.class)
    public void incorrectCvsFileReaderImpl() {
        List<TransactionDto> transactionDtos = reader
                .readData("src/test/resources/test-fruit-incorrect.csv");
    }

    @Test(expected = RuntimeException.class)
    public void incorrectQuantityCvsFileReaderImpl() {
        List<TransactionDto> transactionDtos = reader
                .readData("src/test/resources/test-fruit-incorrect-quantity.csv");
    }

    @Test(expected = RuntimeException.class)
    public void incorrectFileNameCvsFileReaderImpl() {
        List<TransactionDto> transactionDtos = reader.readData("sdfsdf");
    }
}

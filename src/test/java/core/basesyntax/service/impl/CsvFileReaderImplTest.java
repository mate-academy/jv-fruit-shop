package core.basesyntax.service.impl;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class CsvFileReaderImplTest {
    private final CsvFileReaderImpl reader = new CsvFileReaderImpl();

    @Test
    public void correctCvsFileReaderImpl() {
        List<String> transactionDtos = reader
                .readData("src/test/resources/test-fruit-correct.csv");
        Assert.assertEquals("type,fruit,quantity", transactionDtos.get(0));
        Assert.assertEquals("b,banana,20", transactionDtos.get(1));
        Assert.assertEquals("b,apple,100", transactionDtos.get(2));
        Assert.assertEquals("s,banana,100", transactionDtos.get(3));
        Assert.assertEquals(4, transactionDtos.size());
    }

    @Test
    public void incorrectCvsFileReaderImpl() {
        List<String> transactionDtos = reader
                .readData("src/test/resources/test-fruit-incorrect.csv");
        Assert.assertEquals(0, transactionDtos.size());
    }

    @Test(expected = RuntimeException.class)
    public void incorrectFileNameCvsFileReaderImpl() {
        List<String> transactionDtos = reader.readData("sdfsdf");
    }
}

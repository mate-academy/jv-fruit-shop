package core.basesyntax.service.impl;

import static org.junit.Assert.assertEquals;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvFileReaderImplTest {
    public static FileReader csvFileReader;

    @BeforeClass
    public static void beforeClass() {
        csvFileReader = new CsvFileReaderImpl();
    }

    @Test(expected = RuntimeException.class)
     public void empty_Ok() {
        csvFileReader.readData("src/"
                + "test/java/core/service/impl/test.csv");
    }

    @Test(expected = RuntimeException.class)
    public void notACsvFormat_Ok() {
        csvFileReader.readData("src/"
                + "test/java/core/basesyntax/service/impl/test.csv");
    }

    @Test
    public void usualFile_Ok() {
        List<TransactionDto> expected = new ArrayList<>();
        expected.add(new TransactionDto(Operation.BALANCE, new Fruit("banana"), 20));
        assertEquals(expected.get(0).getOperation(), csvFileReader
                .readData("src/test/resources/usual.csv").get(0).getOperation());
        assertEquals(expected.get(0).getFruit(), csvFileReader
                .readData("src/test/resources/usual.csv").get(0).getFruit());
        assertEquals(expected.get(0).getQuantity(), csvFileReader
                .readData("src/test/resources/usual.csv").get(0).getQuantity());
    }
}

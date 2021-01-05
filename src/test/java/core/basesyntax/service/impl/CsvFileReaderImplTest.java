package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CsvFileReaderImplTest {
    public static CsvFileReaderImpl csvFileReader;

    @BeforeAll
    static void beforeAll() {
        csvFileReader = new CsvFileReaderImpl();
    }

    @Test
    void empty_Ok() {
        assertThrows(RuntimeException.class, () -> csvFileReader.readData("src/test/"
                + "java/core/basesyntax/service/impl/CsvFileReaderImplTest.java"));
    }

    @Test
    void notACsvFormat_Ok() {
        assertThrows(RuntimeException.class, () -> csvFileReader.readData("src/"
                + "test/java/core/basesyntax/service/impl/test.csv"));
    }

    @Test
    void usualFile_Ok() {
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

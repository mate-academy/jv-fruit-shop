package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CsvFileWriterImplTest {
    public static CsvFileWriterImpl csvFileWriter;

    @BeforeAll
    static void beforeAll() {
        csvFileWriter = new CsvFileWriterImpl();
    }

    @Test
    void fileNotFound_Ok() {
        assertThrows(RuntimeException.class, () -> csvFileWriter
                .writeDataInFile(new HashMap<>(), ""));
    }
}

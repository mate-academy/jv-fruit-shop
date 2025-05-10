package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.service.TransactionReaderService;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CsvFileTransactionReaderServiceTest {
    private static final String VALID_DATA_FILENAME = "src/test/resources/input_valid.csv";
    private static final int VALID_DATA_LINES_QUANTITY = 8;
    private static final String NONEXISTENT_FILENAME = "src/test/resources/nonexistent.csv";

    @Test
    void read_validInput_success() {
        TransactionReaderService readerService
                = new CsvFileTransactionReaderService(VALID_DATA_FILENAME);
        List<String> list = readerService.read();
        assertEquals(VALID_DATA_LINES_QUANTITY, list.size());
    }

    @Test
    void read_nonexistentFile_fail() {
        TransactionReaderService readerService
                = new CsvFileTransactionReaderService(NONEXISTENT_FILENAME);
        assertThrows(RuntimeException.class, readerService::read);
    }
}

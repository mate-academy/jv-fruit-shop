import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.FileReaderImpl;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileReaderImplTest {
    private FileReaderImpl fileReader;

    @BeforeEach
    public void setUp() {
        fileReader = new FileReaderImpl();
    }

    @Test
    public void testReadTransactionsFileNotFound() {
        try {
            List<FruitTransaction> transactions = fileReader.readTransactions(
                    "nonexistentfile.csv");
            fail("Expected IOException to be thrown");
        } catch (IOException e) {
            assertEquals("Error reading file: nonexistentfile.csv", e.getMessage());
        }
    }
}

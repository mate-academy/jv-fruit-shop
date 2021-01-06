package core.basesyntax.service;

import static org.junit.Assert.assertNotNull;

import core.basesyntax.exception.InvalidFileExtensionException;
import core.basesyntax.service.io.DataReader;
import core.basesyntax.service.io.impl.CsvDataReader;
import java.nio.file.Path;
import org.junit.Test;

public class CsvDataReaderTest {
    private static final String MISSING_FILE_PATH = "src/main/resources/null.csv";
    private static final String INVALID_FILE_PATH = "src/main/resources/null.tsv";
    private static final String VALID_FILE_PATH = "src/main/resources/test_input.csv";
    private DataReader reader;

    @Test(expected = RuntimeException.class)
    public void readFromMissingFileTest() {
        reader = new CsvDataReader();
        reader.readData(Path.of(MISSING_FILE_PATH));
    }

    @Test(expected = InvalidFileExtensionException.class)
    public void readFromInvalidFileTest() {
        reader = new CsvDataReader();
        reader.readData(Path.of(INVALID_FILE_PATH));
    }

    @Test
    public void readFromValidFileTest() {
        reader = new CsvDataReader();
        assertNotNull("One or more lines should be read",
                reader.readData(Path.of(VALID_FILE_PATH)));
    }
}

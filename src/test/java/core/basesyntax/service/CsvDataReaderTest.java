package core.basesyntax.service;

import static org.junit.Assert.assertNotNull;

import core.basesyntax.model.entities.Product;
import core.basesyntax.model.entities.exception.InvalidFileExtensionException;
import core.basesyntax.service.io.DataReader;
import core.basesyntax.service.io.impl.CsvDataReader;
import org.junit.Test;

public class CsvDataReaderTest {
    private static final String MISSING_FILE_PATH = "src/main/resources/null.csv";
    private static final String INVALID_FILE_PATH = "src/main/resources/null.tsv";
    private static final String VALID_FILE_PATH = "src/main/resources/test_input.csv";
    private DataReader<Product> reader;

    @Test(expected = RuntimeException.class)
    public void readFromMissingFileTest() {
        reader = new CsvDataReader<>(MISSING_FILE_PATH);
        reader.readData();
    }

    @Test(expected = InvalidFileExtensionException.class)
    public void readFromInvalidFileTest() {
        reader = new CsvDataReader<>(INVALID_FILE_PATH);
    }

    @Test
    public void readFromValidFileTest() {
        reader = new CsvDataReader<>(VALID_FILE_PATH);
        assertNotNull("One or more lines should be read", reader.readData());
    }
}

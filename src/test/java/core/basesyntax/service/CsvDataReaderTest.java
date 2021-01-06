package core.basesyntax.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

import core.basesyntax.exception.InvalidFileExtensionException;
import core.basesyntax.service.io.DataReader;
import core.basesyntax.service.io.impl.CsvDataReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvDataReaderTest {
    private static final String MISSING_FILE_PATH = "src/test/resources/null.csv";
    private static final String INVALID_FILE_PATH = "src/test/resources/null.tsv";
    private static final String VALID_FILE_PATH = "src/test/resources/test_input.csv";
    private static final List<String[]> EXPECTED_DATA = new ArrayList<>();
    private static DataReader reader;

    @BeforeClass
    public static void setUp() {
        reader = new CsvDataReader();
        EXPECTED_DATA.add(new String[]{"b", "banana", "20"});
    }

    @Test(expected = RuntimeException.class)
    public void readFromMissingFileTest() {
        reader.readData(Path.of(MISSING_FILE_PATH));
    }

    @Test(expected = InvalidFileExtensionException.class)
    public void readFromInvalidFileTest() {
        reader.readData(Path.of(INVALID_FILE_PATH));
    }

    @Test
    public void readFromValidFileTest() {
        List<String[]> actualData = reader.readData(Path.of(VALID_FILE_PATH));
        assertNotNull("One or more lines should be read", actualData);
        assertArrayEquals(EXPECTED_DATA.get(0), actualData.get(0));
    }
}

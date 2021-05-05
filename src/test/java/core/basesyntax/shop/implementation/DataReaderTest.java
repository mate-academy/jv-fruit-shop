package core.basesyntax.shop.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.shop.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DataReaderTest {
    private static final String TEST_FILE_DATA = "src/test/java/core/"
            + "basesyntax/resources/fileWithInputData.csv";
    private static final String TEST_FILE_INCORRECT = "src/test/java/core/"
            + "basesyntax/resources/testFiles.txt";
    private static FileReader dataReader;

    @BeforeAll
    static void beforeAll() {
        dataReader = new DataReader();
    }

    @Test
    void readFromInputData_Ok() {
        List<String> expected;
        try {
            expected = Files.readAllLines(Path.of(TEST_FILE_DATA));
        } catch (IOException e) {
            throw new RuntimeException("Can't find test file: " + TEST_FILE_DATA,e);
        }
        List<String> actual = dataReader.readFromInputData(TEST_FILE_DATA);
        assertEquals(expected, actual);
    }

    @Test
    void readFromInputData_NotOk() {
        assertThrows(RuntimeException.class,
                () -> dataReader.readFromInputData(TEST_FILE_INCORRECT));
    }
}

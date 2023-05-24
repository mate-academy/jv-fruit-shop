package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@DisplayName("ReaderCsvImpl Test")
class FileReaderServiceCsvImplTest {
    private FileReaderServiceCsvImpl reader;

    @DisplayName("Check reader CSV with valid file")
    @Test
    @Order(1)
    void readFile_validClasspath_ok() {
        reader = new FileReaderServiceCsvImpl("src/test/resources/input/testFile.csv");
        List<String> expectedList = List.of(
                "type,fruit,quantity",
                "b,banana,20",
                "b,apple,100",
                "s,banana,100",
                "p,banana,13",
                "r,apple,10",
                "p,apple,20",
                "p,banana,5",
                "s,banana,50");
        List<String> actualList = reader.readFile();
        assertEquals(expectedList, actualList);
    }

    @DisplayName("Check reader CSV with invalid file")
    @Test
    @Order(2)
    void readFile_invalidClasspath_notOk() {
        reader = new FileReaderServiceCsvImpl("invalid/classpath");
        assertThrows(RuntimeException.class, () -> reader.readFile(),
                "Should throw an exception");
    }

    @DisplayName("Check reader CSV with valid empty file")
    @Test
    @Order(3)
    void readFile_emptyFile_ok() {
        reader = new FileReaderServiceCsvImpl("src/test/resources/input/empty.csv");
        List<String> expectedList = new ArrayList<>();
        List<String> actualList = reader.readFile();
        assertEquals(expectedList, actualList);
    }

    @DisplayName("Check reader CSV with one line file")
    @Test
    @Order(4)
    void readFile_oneLine_ok() {
        reader = new FileReaderServiceCsvImpl("src/test/resources/input/oneLine.csv");
        List<String> expectedList = List.of("type,fruit,quantity");
        List<String> actualList = reader.readFile();
        assertEquals(expectedList, actualList);
    }

    @DisplayName("Check reader CSV with invalid file extension")
    @Test
    @Order(5)
    void readFile_invalidFileExtension_notOk() {
        reader = new FileReaderServiceCsvImpl("src/test/resources/input/wrongExtension");
        assertThrows(RuntimeException.class, () -> reader.readFile(),
                "Should throw an exception");
    }
}

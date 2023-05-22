package core.basesyntax.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReaderCsvImplTest {
    private ReaderCsvImpl reader;

    @AfterEach
    void tearDown() {
        reader = null;
    }

    @Test
    @Order(1)
    void readFile_validClasspath_ok() {
        reader = new ReaderCsvImpl("src/main/resources/testFile.csv");
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

    @Test
    @Order(2)
    void readFile_invalidClasspath_notOk() {
        reader = new ReaderCsvImpl("invalid/classpath");
        assertThrows(RuntimeException.class, () -> reader.readFile(),
                "Should throw an exception");
    }

    @Test
    @Order(3)
    void readFile_emptyFile_ok() {
        reader = new ReaderCsvImpl("src/main/resources/empty.csv");
        List<String> expectedList = new ArrayList<>();
        List<String> actualList = reader.readFile();
        assertEquals(expectedList, actualList);
    }

    @Test
    @Order(4)
    void readFile_oneLine_ok() {
        reader = new ReaderCsvImpl("src/main/resources/oneLine.csv");
        List<String> expectedList = List.of("type,fruit,quantity");
        List<String> actualList = reader.readFile();
        assertEquals(expectedList, actualList);
    }

    @Test
    @Order(5)
    void readFile_invalidFileExtension_notOk() {
        reader = new ReaderCsvImpl("src/main/resources/wrongExtension");
        assertThrows(RuntimeException.class, () -> reader.readFile(),
                "Should throw an exception");
    }
}
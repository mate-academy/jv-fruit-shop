package core.basesyntax.service.impl;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.service.Writer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@DisplayName("WriterToCsvImpl Test")
class WriterToCsvImplTest {
    private static final String PATH = "src/test/resources/output";
    private static final File FILE = new File(PATH + File.separator + "reportFile.csv");
    private static Writer writer;

    @BeforeEach
    void setUp() {
        writer = new WriterToCsvImpl(PATH);
    }

    @AfterEach
    void tearDown() {
        FILE.delete();
    }

    @DisplayName("Check writing to file in correct path")
    @Order(1)
    @Test
    void writeInFile_correctPath_ok() {
        List<String> expected = List.of("fruit,quantity",
                "banana,20",
                "apple,10");
        writer.writeToFile(expected);
        List<String> actual;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE))) {
            actual = bufferedReader.lines().collect(toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file: " + FILE.getPath(), e);
        }
        assertEquals(expected, actual);
    }

    @DisplayName("Check writing to file in incorrect path")
    @Order(2)
    @Test
    void writeInFile_incorrectPath_notOk() {
        writer = new WriterToCsvImpl("src/test/resources/incorrectPath");
        assertThrows(RuntimeException.class, () -> writer.writeToFile(List.of()));
    }
}

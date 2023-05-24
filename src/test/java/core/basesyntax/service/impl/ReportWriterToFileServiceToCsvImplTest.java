package core.basesyntax.service.impl;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.service.ReportWriterToFileService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@DisplayName("WriterToCsvImpl Test")
class ReportWriterToFileServiceToCsvImplTest {
    private static final File FILE = new File("src/test/resources/output/reportFile.csv");
    private static ReportWriterToFileService reportWriterToFileService;

    @AfterEach
    void tearDown() {
        FILE.delete();
    }

    @DisplayName("Check writing to file in correct path")
    @Order(1)
    @Test
    void writeInFile_correctPath_ok() {
        reportWriterToFileService = new ReportWriterToFileServiceToCsvImpl(FILE.getPath());
        List<String> expected = List.of("fruit,quantity",
                "banana,20",
                "apple,10");
        reportWriterToFileService.writeToFile(expected);
        List<String> actual;
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("src/test/resources/output/reportFile.csv"))) {
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
        reportWriterToFileService =
                new ReportWriterToFileServiceToCsvImpl(
                        "src/test/resources/incorrectPath/reportFile.csv");
        assertThrows(RuntimeException.class, () ->
                reportWriterToFileService.writeToFile(List.of()));
    }

    @DisplayName("Check writing to file with incorrect extension")
    @Order(3)
    @Test
    void writeInFile_incorrectExtension_notOk() {
        reportWriterToFileService =
                new ReportWriterToFileServiceToCsvImpl(
                        "src/test/resources/reportFile.txt");
        assertThrows(RuntimeException.class, () ->
                reportWriterToFileService.writeToFile(List.of()));
    }
}

package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import core.basesyntax.service.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CsvFileWriterTest {
    static final String PATH_TO_ACTUAL = "src/test/resources/actual.csv";
    static final String PATH_TO_EXPECTED = "src/test/resources/actual.csv";
    static FileWriter fileWriter;
    static Map<String, Long> report;

    @BeforeAll
    static void beforeAll() {
        fileWriter = new CsvFileWriter();
        report = new HashMap<>();
        report.put("banana", 152L);
        report.put("apple", 90L);
    }

    @Test
    void writeToCsv_Ok() {
        fileWriter.writeReportToFile(report, PATH_TO_ACTUAL);
        File expected = new File(PATH_TO_EXPECTED);
        File actual = new File(PATH_TO_ACTUAL);
        try {
            assertTrue(FileUtils.contentEquals(expected, actual));
        } catch (IOException e) {
            fail("Exception not may be throwed");
        }
    }
}

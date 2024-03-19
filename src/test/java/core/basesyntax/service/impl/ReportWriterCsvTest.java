package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import core.basesyntax.service.ReportReader;
import core.basesyntax.service.ReportWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReportWriterCsvTest {
    private static final String REPORT_CSV = "src/test/resources/report.csv";
    private ReportReader reportReader;
    private ReportWriter reportWriter;

    @BeforeEach
    void setUp() {
        reportReader = new ReportReaderCsv();
        reportWriter = new ReportWriterCsv();
    }

    @AfterEach
    void tearDown() {
        try {
            Files.deleteIfExists(Path.of(REPORT_CSV));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void writeReport_ok() {
        String data = """
                fruit,quantity
                apple,50
                banana,20
                """;
        reportWriter.writeReport(data, REPORT_CSV);
        File file = new File(REPORT_CSV);
        assertTrue(file.exists());
        List<String> actual = reportReader.readFile(REPORT_CSV);
        List<String> expected = List.of("fruit,quantity", "apple,50", "banana,20");
        assertEquals(expected, actual);
    }

    @Test
    void writeReport_emptyData_notOk() {
        assertThrows(IllegalArgumentException.class, () ->
                reportWriter.writeReport(null, REPORT_CSV));
    }
}

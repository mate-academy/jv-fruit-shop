package core.basesyntax.service;

import static org.junit.Assert.assertTrue;

import core.basesyntax.exception.InvalidFileExtensionException;
import core.basesyntax.model.entities.Fruit;
import core.basesyntax.model.entities.Product;
import core.basesyntax.service.io.ReportWriter;
import core.basesyntax.service.io.impl.CsvReportWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvReportWriterTest {
    private static final List<String[]> TEST_DATA = new ArrayList<>();
    private static final Product TEST_PRODUCT = new Fruit("test");
    private static final Integer TEST_AMOUNT = 10;
    private static final String INVALID_REPORT_PATH = "src/main/resources/null.tsv";
    private static final String VALID_REPORT_PATH = "src/main/resources/test_report.csv";
    private ReportWriter writer;

    @BeforeClass
    public static void setUp() {
        TEST_DATA.add(new String[] {TEST_PRODUCT.getName(), String.valueOf(TEST_AMOUNT)});
    }

    @Test
    public void writeToValidFileTest() throws IOException {
        writer = new CsvReportWriter();
        writer.writeReport(Path.of(VALID_REPORT_PATH), TEST_DATA);
        assertTrue("One or more lines should be written",
                Files.readAllLines(Path.of(VALID_REPORT_PATH)).size() > 1);
        Files.delete(Path.of(VALID_REPORT_PATH));
    }

    @Test(expected = InvalidFileExtensionException.class)
    public void writeToInvalidFileTest() {
        writer = new CsvReportWriter();
        writer.writeReport(Path.of(INVALID_REPORT_PATH), TEST_DATA);
    }
}

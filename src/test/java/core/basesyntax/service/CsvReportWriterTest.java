package core.basesyntax.service;

import static org.junit.Assert.assertEquals;
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
    private static final String INVALID_REPORT_PATH = "src/test/resources/null.tsv";
    private static final String VALID_REPORT_PATH = "src/test/resources/test_report.csv";
    private static ReportWriter writer;

    @BeforeClass
    public static void setUp() {
        writer = new CsvReportWriter();
        TEST_DATA.add(new String[] {TEST_PRODUCT.getName(), String.valueOf(TEST_AMOUNT)});
    }

    @Test
    public void writeToValidFileTest() throws IOException {
        writer.writeReport(Path.of(VALID_REPORT_PATH), TEST_DATA);
        List<String> actualWrittenData = Files.readAllLines(Path.of(VALID_REPORT_PATH));
        assertTrue("One or more lines should be written",
                actualWrittenData.size() > 1);
        assertEquals("Incorrect data written",
                TEST_PRODUCT.getName() + "," + TEST_AMOUNT, actualWrittenData.get(1));
        Files.delete(Path.of(VALID_REPORT_PATH));
    }

    @Test(expected = InvalidFileExtensionException.class)
    public void writeToInvalidFileTest() {
        writer.writeReport(Path.of(INVALID_REPORT_PATH), TEST_DATA);
    }
}

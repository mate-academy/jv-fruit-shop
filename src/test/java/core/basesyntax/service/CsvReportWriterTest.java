package core.basesyntax.service;

import static org.junit.Assert.assertTrue;

import core.basesyntax.db.Warehouse;
import core.basesyntax.model.entities.Fruit;
import core.basesyntax.model.entities.Product;
import core.basesyntax.model.entities.exception.InvalidFileExtensionException;
import core.basesyntax.service.io.ReportWriter;
import core.basesyntax.service.io.impl.CsvReportWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvReportWriterTest {
    private static final Warehouse<Product> testWarehouse = new Warehouse<>();
    private static final Product TEST_PRODUCT = new Fruit("test");
    private static final Integer TEST_AMOUNT = 10;
    private static final String INVALID_REPORT_PATH = "src/main/resources/null.tsv";
    private static final String VALID_REPORT_PATH = "src/main/resources/test_report.csv";
    private ReportWriter<Product> writer;

    @BeforeClass
    public static void setUp() {
        testWarehouse.getStorage().put(TEST_PRODUCT, TEST_AMOUNT);
    }

    @Test
    public void writeToValidFileTest() throws IOException {
        writer = new CsvReportWriter<>(VALID_REPORT_PATH);
        writer.writeReport(testWarehouse);
        assertTrue("One or more lines should be written",
                Files.readAllLines(Path.of(VALID_REPORT_PATH)).size() > 1);
        Files.delete(Path.of(VALID_REPORT_PATH));
    }

    @Test(expected = InvalidFileExtensionException.class)
    public void writeToInvalidFileTest() {
        writer = new CsvReportWriter<>(INVALID_REPORT_PATH);
        writer.writeReport(testWarehouse);
    }
}

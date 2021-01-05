package core.basesyntax.service;

import static org.junit.Assert.assertTrue;

import core.basesyntax.model.entities.Fruit;
import core.basesyntax.service.io.ReportWriter;
import core.basesyntax.service.io.impl.CsvReportWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

public class FruitServiceTest {
    private static final List<String[]> TEST_DATA = new ArrayList<>();
    private static final String REPORT_FILE_PATH = "src/main/resources/service_test_report.csv";
    private static ReportWriter<Fruit> writer;
    private final FruitService fruitService = new FruitService();

    @BeforeClass
    public static void setUp() {
        TEST_DATA.add(new String[]{"b", "test", "10"});
        writer = new CsvReportWriter<>(REPORT_FILE_PATH);
    }

    @Test
    public void importData_ok() {
        fruitService.importData(TEST_DATA);
        assertTrue("One or more lines should be imported",
                fruitService.getWarehouse().getStorage().size() >= 1);
    }

    @Test
    public void writeReport_ok() throws IOException {
        fruitService.importData(TEST_DATA);
        fruitService.writeReport(writer);
        writer.writeReport(fruitService.getWarehouse());
        assertTrue("One or more lines should be written",
                Files.readAllLines(Path.of(REPORT_FILE_PATH)).size() > 1);
        Files.delete(Path.of(REPORT_FILE_PATH));
    }
}

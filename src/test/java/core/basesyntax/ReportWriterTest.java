package core.basesyntax;

import core.basesyntax.service.ReportWriter;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Path;


public class ReportWriterTest {
    private static final String REFERENCE_FILE = "src/test/resources/data.csv";
    private static final String EMPTY_FILE_PATH = "src/test/resources/empty.csv";
    private static final String SINGLE_FRUIT = "src/test/resources/single_fruit.csv";
    private static final Path GENERATED_PATH = Path.of("src/test/out/test.csv");
    private static ReportWriter reportWriter;

    @BeforeClass
    public static void setReportWriter() {
        reportWriter = new ReportWriter();
    }

    @Test
    public void getResultOK() {
        String report = reportWriter.getReport(REFERENCE_FILE);
        Assert.assertEquals("fruit,quantity\n" +
                "banana,77\n" +
                "orange,105\n" +
                "apple,557", report );
    }

    @Test
    public void getSingleFruit() {
        String report = reportWriter.getReport(SINGLE_FRUIT);
        Assert.assertEquals("fruit,quantity\n" +
                "banana,90", report);
    }

    @Test
    public void getEmptyResult() {
        String report = reportWriter.getReport(EMPTY_FILE_PATH);
        Assert.assertEquals("fruit,quantity", report);
    }

    @Test
    public void getFileExist() {
        reportWriter.getReport(REFERENCE_FILE);
        Assert.assertTrue(Files.exists(GENERATED_PATH));
    }
}

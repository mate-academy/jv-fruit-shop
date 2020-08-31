package core.basesyntax;

import model.Position;
import model.Storage;
import org.junit.Assert;
import org.junit.Test;
import services.ReportService;
import java.io.File;
import java.time.LocalDate;

public class ReportServiceTest {
    private static final String FRUIT_NAME = "banana";
    private static final String FILE_PATH_TO_WRITE_RESULT = "src/test/java/results/result.txt";
    private static final int ONE = 1;
    private static final int TEN = 10;
    private static final LocalDate DATE_IN_FUTURE = LocalDate.now().plusDays(ONE);
    private static ReportService reportService = new ReportService();
    
    Position position = new Position(FRUIT_NAME, TEN, DATE_IN_FUTURE);

    @Test
    public void printReportIntoFileTest() {
        Storage.storage.put(FRUIT_NAME, position);
        reportService.printReportIntoFile();
        File expected = new File(FILE_PATH_TO_WRITE_RESULT);
        Assert.assertTrue(expected.exists()
                && expected.length() != 0
                && !expected.isDirectory());
    }
}

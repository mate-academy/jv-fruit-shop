package core.basesyntax;

import model.Position;
import model.Storage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import services.ReportService;
import services.StorageServiceImpl;
import java.time.LocalDate;

public class StorageServiceImplTest {
    private static final int ONE = 1;
    private static final int TEN = 10;
    private static final LocalDate DATE_IN_FUTURE = LocalDate.now().plusDays(ONE);
    private static final String FRUIT_NAME = "banana";
    private static Position position;
    private static ReportService reportService;
    private static StorageServiceImpl storageServiceImpl;

    @BeforeClass
    public static void setUp() {
        position = new Position(FRUIT_NAME, TEN, DATE_IN_FUTURE);
        reportService = new ReportService();
        storageServiceImpl = new StorageServiceImpl();
    }

    @Test
    public void putTest() {
        storageServiceImpl.put(position);
        boolean expected = Storage.storage.containsValue(position);
        Assert.assertTrue(expected);
    }
}

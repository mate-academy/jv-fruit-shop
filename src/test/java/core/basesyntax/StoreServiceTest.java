package core.basesyntax;

import core.basesyntax.servise.StoreService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.NoSuchElementException;

public class StoreServiceTest {
    private static final String ALL_OPERATIONS_EXECUTE_PATH = "src\\test\\resources\\file.csv";
    private static final String READ_CORRECT_FILE_PATH = "src\\test\\resources\\fileServiceCorrect.csv";
    private static final String READ_INCORRECT_FILE_PATH = "src\\test\\resources\\incorrectFileOperation.csv";
    private static final String STORE_SERVICE_REPORT = "src\\test\\resources\\storeServiceTestReport.csv";
    private StoreService storeService;

    @Before
    public void init() {
        storeService = new StoreService();
    }

    @Test
    public void checkCorrectGetListShopStorageInfo() {
        storeService.loadFileOperations(READ_CORRECT_FILE_PATH);
        List<String> storageInfo = storeService.getListShopStorageInfo();
        List<String> expected = List.of("fruit,quantity", "banana,100");
        Assert.assertEquals(expected, storageInfo);
        Assert.assertEquals(storageInfo.size(), 2);
    }

    @Test(expected = NoSuchElementException.class)
    public void checkLoadFileOperationsWithIncorrectTypeOperation() {
        storeService.loadFileOperations(READ_INCORRECT_FILE_PATH);
    }

    @Test
    public void checkCreateStorageReportFile() throws IOException {
        storeService.loadFileOperations(ALL_OPERATIONS_EXECUTE_PATH);
        storeService.createStorageReportFile(STORE_SERVICE_REPORT);
        Assert.assertTrue(Files.exists(Path.of(STORE_SERVICE_REPORT)));
        List<String> expected = List.of("fruit,quantity", "banana,100", "orange,100", "apple,30");
        List<String> actual = null;
        actual = Files.readAllLines(Path.of(STORE_SERVICE_REPORT));
        Assert.assertEquals(expected, actual);
    }
}
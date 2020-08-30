package core.basesyntax;

import core.basesyntax.service.StorageService;
import org.junit.BeforeClass;
import org.junit.Test;

public class StorageServiceTest {
    private static final String WRONG_FILE_PATH = "src/test/resources/wrong.csv";
    private static final String NOT_ENOUGH_ITEMS = "src/test/resources/not_enough.csv";
    private static final String NO_FRESH_ITEMS = "src/test/resources/no_fresh.csv";
    private static final String NO_SUCH_OPERATION = "src/test/resources/no_operation.csv";
    private static StorageService storageService;

    @BeforeClass
    public static void setStorageService() {
        storageService = new StorageService();
    }

    @Test(expected = RuntimeException.class)
    public void getBuyBeforeSupply() {
        storageService.storageWriter(WRONG_FILE_PATH);
    }

    @Test(expected = RuntimeException.class)
    public void notEnoughItems() {
        storageService.storageWriter(NOT_ENOUGH_ITEMS);
    }

    @Test(expected = RuntimeException.class)
    public void noFreshFood() {
        storageService.storageWriter(NO_FRESH_ITEMS);
    }

    @Test(expected = RuntimeException.class)
    public void noValidOperation() {
        storageService.storageWriter(NO_SUCH_OPERATION);
    }
}

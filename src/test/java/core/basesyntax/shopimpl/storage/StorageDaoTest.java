package core.basesyntax.shopimpl.storage;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class StorageDaoTest {
    StorageDao testStorageDao;
    
    @Test
    public void testGetAllActionsNoFile() {
        String path = "src/test/java/core/basesyntax/shopimpl"
                + "/storage/DatabaseNoFile.csv";
        Assertions.assertThrows(RuntimeException.class, () -> new StorageDao(path));
    }
    
    @Test
    public void testGetAllActionsEmptyFile() {
        testStorageDao = new StorageDao("src/test/java/core/basesyntax/shopimpl"
                + "/storage/DatabaseEmptyFile.csv");
        List<DataRecord> list = testStorageDao.getAllActions();
        int expectedSize = 0;
        int actualSize = list.size();
        Assertions.assertEquals(expectedSize, actualSize);
    }
    
    public void testGetItemActions() {
    }
    
    public void testAddAction() {
    }
    
    public void testTestAddAction() {
    }
    
    public void testClose() {
    }
}
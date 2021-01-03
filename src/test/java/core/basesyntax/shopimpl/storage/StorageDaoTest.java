package core.basesyntax.shopimpl.storage;

import java.util.List;
import junit.framework.TestCase;

public class StorageDaoTest extends TestCase {
    StorageDao testStorageDao;
    
    
    public void testGetAllActionsEmptyFile() {
        testStorageDao = new StorageDao("src/test/java/core/basesyntax/shopimpl/storage/DatabaseEmptyFile.csv");
        List<DataRecord> list = testStorageDao.getAllActions();
        int expectedSize = 0;
        int actualSize = list.size();
        assertEquals(expectedSize, actualSize);
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
package core.basesyntax.shopimpl.storage;

import core.basesyntax.model.shopstrategy.ShopActions;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class StorageDaoTest {
    private StorageDao testStorageDao;
    
    @Test
    public void getAllActionsNonExistingFile() {
        String path = "src/test/java/core/basesyntax/shopimpl"
                      + "/storage/DatabaseNoFile.csv";
        Assertions.assertThrows(RuntimeException.class, () -> new StorageDao(path));
    }
    
    @Test
    public void getAllActionsEmptyFile() {
        testStorageDao = new StorageDao("src/test/java/core/basesyntax/shopimpl"
                                        + "/storage/DatabaseEmptyFile.csv");
        List<DataRecord> list = testStorageDao.getAllActions();
        int expectedSize = 0;
        int actualSize = list.size();
        Assertions.assertEquals(expectedSize, actualSize);
    }
    
    @Test
    public void getItemActions() {
        String path = "src/test/java/core/basesyntax/shopimpl"
                      + "/storage/getItemActionsTestFile.csv";
        testStorageDao = new StorageDao(path);
        testStorageDao.addAction(ShopActions.SUPPLY, "oranges", 100);
        testStorageDao.addAction(ShopActions.RETURN, "oranges", 10);
        testStorageDao.addAction(ShopActions.RETURN, "nuts", 10);
        testStorageDao.addAction(new DataRecord(ShopActions.SUPPLY, "nuts", 100));
        
        List<DataRecord> actual = testStorageDao.getItemActions("banana");
        List<DataRecord> expected
                = List.of(new DataRecord(ShopActions.PURCHASE, "banana", 15),
                new DataRecord(ShopActions.SUPPLY, "banana", 200));
        
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    public void addAction() {
        String path = "src/test/java/core/basesyntax/shopimpl"
                      + "/storage/getItemActionsTestFile.csv";
        testStorageDao = new StorageDao(path);
        testStorageDao.addAction(ShopActions.SUPPLY, "oranges", 100);
        testStorageDao.addAction(ShopActions.RETURN, "oranges", 10);
        testStorageDao.addAction(ShopActions.RETURN, "nuts", 10);
        testStorageDao.addAction(ShopActions.SUPPLY, "nuts", 100);
        
        int actual = testStorageDao.getAllActions().size();
        int expected = 7;
        
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    public void closeEmptyFileWithNonEmptyInput() {
        String path = "src/test/java/core/basesyntax/shopimpl/storage/closeTestEmptyFile.csv";
        testStorageDao = new StorageDao(path);
        
        testStorageDao.addAction(ShopActions.PURCHASE, "apple", 10);
        testStorageDao.addAction(ShopActions.PURCHASE, "banana", 15);
        testStorageDao.addAction(ShopActions.SUPPLY, "banana", 200);
        
        testStorageDao.close();
        
        try {
            List<String> expected = List.of("ShopAction,Item,Amount",
                    "PURCHASE,apple,10",
                    "PURCHASE,banana,15",
                    "SUPPLY,banana,200");
            List<String> actual = Files.readAllLines(Path.of(path));
            Assertions.assertLinesMatch(expected, actual);
        } catch (IOException e) {
            throw new RuntimeException("A problem has occurred while working with file", e);
        } finally {
            try {
                Files.deleteIfExists(Path.of(path));
                Files.createFile(Path.of(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }
}
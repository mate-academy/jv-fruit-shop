package core.basesyntax.shopimpl.storage;

import core.basesyntax.model.shopstrategy.ShopActions;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class StorageDaoTest {
    private StorageDao testStorageDao;
    
    @BeforeEach
    void setUp() {
        testStorageDao = null;
    }
    
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
    }
    
    @Test
    public void addAction() {
    
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
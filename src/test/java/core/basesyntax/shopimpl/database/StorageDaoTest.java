package core.basesyntax.shopimpl.database;

import core.basesyntax.model.shopstrategy.ShopActions;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.entity.Fruit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StorageDaoTest {
    private FruitShopDao testFruitShopDao;
    
    @Test
    public void getAllActionsNonExistingFile() {
        String path = "src/test/java/core/basesyntax/shopimpl"
                      + "/storage/DatabaseNoFile.csv";
        Assertions.assertThrows(RuntimeException.class, () -> new FruitShopDao(path));
    }
    
    @Test
    public void getAllActionsEmptyFile() {
        testFruitShopDao = new FruitShopDao("src/test/java/core/basesyntax"
                                            + "/shopimpl/database/DatabaseEmptyFile.csv");
        List<DataRecord> list = testFruitShopDao.getTransactionHistory();
        int expectedSize = 0;
        int actualSize = list.size();
        Assertions.assertEquals(expectedSize, actualSize);
    }
    
    @Test
    public void getItemActions() {
        String path = "src/test/java/core/basesyntax/shopimpl/database/getItemActionsTestFile.csv";
        testFruitShopDao = new FruitShopDao(path);
        testFruitShopDao.addAction(ShopActions.SUPPLY, "oranges", 100);
        testFruitShopDao.addAction(ShopActions.RETURN, "oranges", 10);
        testFruitShopDao.addAction(ShopActions.RETURN, "nuts", 10);
        testFruitShopDao.addTransaction(new DataRecord(ShopActions.SUPPLY, new Fruit("nuts"), 100));
        
        List<DataRecord> actual = testFruitShopDao.getItemTransactionHistory("banana");
        List<DataRecord> expected
                = List.of(new DataRecord(ShopActions.PURCHASE, new Fruit("banana"), 15),
                new DataRecord(ShopActions.SUPPLY, new Fruit("banana"), 200));
        
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    public void addAction() {
        String path = "src/test/java/core/basesyntax/shopimpl/database/getItemActionsTestFile.csv";
        testFruitShopDao = new FruitShopDao(path);
        testFruitShopDao.addAction(ShopActions.SUPPLY, "oranges", 100);
        testFruitShopDao.addAction(ShopActions.RETURN, "oranges", 10);
        testFruitShopDao.addAction(ShopActions.RETURN, "nuts", 10);
        testFruitShopDao.addAction(ShopActions.SUPPLY, "nuts", 100);
        
        int actual = testFruitShopDao.getTransactionHistory().size();
        int expected = 7;
        
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    public void updateEmptyFileWithNonEmptyInput() {
        String path = "src/test/java/core/basesyntax/shopimpl/database/updateTestEmptyFile.csv";
        testFruitShopDao = new FruitShopDao(path);
        
        testFruitShopDao.addAction(ShopActions.PURCHASE, "apple", 10);
        testFruitShopDao.addAction(ShopActions.PURCHASE, "banana", 15);
        testFruitShopDao.addAction(ShopActions.SUPPLY, "banana", 200);
        
        testFruitShopDao.updateDatabase();
        
        try {
            List<String> expected = List.of("ShopAction,Item,Amount",
                    "p,apple,10",
                    "p,banana,15",
                    "s,banana,200");
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
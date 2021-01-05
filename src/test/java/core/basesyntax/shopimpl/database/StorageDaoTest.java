package core.basesyntax.shopimpl.database;

import static org.junit.Assert.assertEquals;

import core.basesyntax.model.shopstrategy.ShopTransactionsTypes;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.entity.Fruit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.Test;

public class StorageDaoTest {
    private FruitShopDao testFruitShopDao;
    
    @Test(expected = RuntimeException.class)
    public void getAllActionsNonExistingFile() {
        String path = "src/test/resources/DatabaseNoFile.csv";
        new FruitShopDao(path);
    }
    
    @Test
    public void getAllActionsEmptyFile() {
        testFruitShopDao = new FruitShopDao("src/test/resources/DatabaseEmptyFile.csv");
        List<DataRecord> list = testFruitShopDao.getTransactionHistory();
        int expectedSize = 0;
        int actualSize = list.size();
        assertEquals(expectedSize, actualSize);
    }
    
    @Test
    public void getItemActions() {
        String path = "src/test/resources/getItemActionsTestFile.csv";
        testFruitShopDao = new FruitShopDao(path);
        testFruitShopDao.addAction(ShopTransactionsTypes.SUPPLY, "oranges", 100);
        testFruitShopDao.addAction(ShopTransactionsTypes.RETURN, "oranges", 10);
        testFruitShopDao.addAction(ShopTransactionsTypes.RETURN, "nuts", 10);
        testFruitShopDao.addTransaction(new DataRecord(ShopTransactionsTypes.SUPPLY,
                new Fruit("nuts"),
                100));
        
        List<DataRecord> actual = testFruitShopDao.getItemTransactionHistory("banana");
        List<DataRecord> expected
                = List.of(new DataRecord(ShopTransactionsTypes.PURCHASE, new Fruit("banana"), 15),
                new DataRecord(ShopTransactionsTypes.SUPPLY, new Fruit("banana"), 200));
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void addAction() {
        String path = "src/test/resources/getItemActionsTestFile.csv";
        testFruitShopDao = new FruitShopDao(path);
        testFruitShopDao.addAction(ShopTransactionsTypes.SUPPLY, "oranges", 100);
        testFruitShopDao.addAction(ShopTransactionsTypes.RETURN, "oranges", 10);
        testFruitShopDao.addAction(ShopTransactionsTypes.RETURN, "nuts", 10);
        testFruitShopDao.addAction(ShopTransactionsTypes.SUPPLY, "nuts", 100);
        
        int actual = testFruitShopDao.getTransactionHistory().size();
        int expected = 7;
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void updateEmptyFileWithNonEmptyInput() {
        String path = "src/test/resources/updateTestEmptyFile.csv";
        testFruitShopDao = new FruitShopDao(path);
        
        testFruitShopDao.addAction(ShopTransactionsTypes.PURCHASE, "apple", 10);
        testFruitShopDao.addAction(ShopTransactionsTypes.PURCHASE, "banana", 15);
        testFruitShopDao.addAction(ShopTransactionsTypes.SUPPLY, "banana", 200);
        
        testFruitShopDao.updateDatabase();
        
        try {
            List<String> expected = List.of("ShopAction,Item,Amount",
                    "p,apple,10",
                    "p,banana,15",
                    "s,banana,200");
            List<String> actual = Files.readAllLines(Path.of(path));
            assertEquals(expected, actual);
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

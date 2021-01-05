package core.basesyntax.shopimpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import core.basesyntax.model.abstractstorage.AbstractStorage;
import core.basesyntax.model.shopdao.ShopDao;
import core.basesyntax.model.shopstrategy.ShopTransactionsTypes;
import core.basesyntax.shopimpl.database.FruitShopDao;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.entity.Fruit;
import core.basesyntax.shopimpl.storage.FruitShopStorage;
import org.junit.Test;

public class FruitShopTest {
    private String emptyFilePath
            = "src/test/resources/EmptyTestDatabase.csv";
    private String illegalEntryFilePath
            = "src/test/resources/IllegalEntryTestDatabase.csv";
    private String illegalArgumentFilePath
            = "src/test/resources/IllegalArgumentTestDatabase.csv";
    private String severalFruitsFilePath
            = "src/test/resources/SeveralFruitsDatabase.csv";
    private ShopDao<DataRecord> shopDao;
    private AbstractStorage<DataRecord, Fruit> storage;
    
    @Test
    public void emptyFileStorageInit() {
        shopDao = new FruitShopDao(emptyFilePath);
        storage = new FruitShopStorage(shopDao);
        int actual = storage.getStorage().size();
        int expected = 0;
        assertEquals(expected, actual);
    }
    
    @Test(expected = IllegalStateException.class)
    public void illegalEntryFileStorageInit() {
        shopDao = new FruitShopDao(illegalEntryFilePath);
        storage = new FruitShopStorage(shopDao);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentFileStorageInit() {
        shopDao = new FruitShopDao(illegalArgumentFilePath);
        storage = new FruitShopStorage(shopDao);
    }
    
    @Test
    public void severalFruitsStorageInit() {
        shopDao = new FruitShopDao(severalFruitsFilePath);
        storage = new FruitShopStorage(shopDao);
        
        int actual = storage.getStorage().size();
        int expected = 4;
        assertEquals(expected, actual);
        DataRecord expectedRecord = new DataRecord(ShopTransactionsTypes.BALANCE,
                new Fruit("Fruit"),
                100);
        assertTrue(shopDao.getTransactionHistory().contains(expectedRecord));
        assertTrue(storage.getStorage().containsKey(expectedRecord.getItem()));
    }
    
    @Test
    public void severalFruitsAndActionsStorageInit() {
    
    }
    
    //    @Test(expected = IllegalPurchaseAmountException.class)
    //    public void shopExceptionExpected() {
    //        shopDao = new FruitShopDao(illegalEntryFilePath);
    //        storage = new FruitShopStorage(shopDao);
    //    }
    
    @Test
    public void performAction() {
    
    }
}

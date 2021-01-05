package core.basesyntax.shopimpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import core.basesyntax.model.AbstractShop;
import core.basesyntax.model.abstractstorage.AbstractStorage;
import core.basesyntax.model.shopdao.ShopDao;
import core.basesyntax.model.shopstrategy.ShopTransactionsTypes;
import core.basesyntax.shopimpl.database.FruitShopDao;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.entity.Fruit;
import core.basesyntax.shopimpl.storage.FruitShopStorage;
import org.junit.Test;

public class FruitShopTest {
    private static AbstractShop<DataRecord, Fruit> shop;
    private String emptyFilePath
            = "src/test/resources/EmptyTestDatabase.csv";
    private String illegalEntryFilePath
            = "src/test/resources/IllegalEntryTestDatabase.csv";
    private String illegalArgumentFilePath
            = "src/test/resources/IllegalArgumentTestDatabase.csv";
    private String severalFruitsFilePath
            = "src/test/resources/SeveralFruitsDatabase.csv";
    private String getSeveralFruitsAndActionFilePath
            = "src/test/resources/SeveralFruitsAndActionsTestDatabase.csv";
    private String testDatabase
            = "src/test/resources/testDataBase.csv";
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
        shopDao = new FruitShopDao(getSeveralFruitsAndActionFilePath);
        storage = new FruitShopStorage(shopDao);
        
        int actualAmountFruit1 = storage.getStorage().get(new Fruit("Fruit1"));
        int expectedAmountFruit1 = 80;
        assertEquals(expectedAmountFruit1, actualAmountFruit1);
    }
    
    @Test(expected = RuntimeException.class)
    public void shopExceptionExpected() {
        shopDao = new FruitShopDao(testDatabase);
        storage = new FruitShopStorage(shopDao);
        shop = new FruitShop(storage, shopDao);
        
        shop.performAction(ShopTransactionsTypes.PURCHASE, new Fruit("Fruit1"), 1000);
    }
    
    @Test
    public void shopAddNewProduct() {
        shopDao = new FruitShopDao(testDatabase);
        storage = new FruitShopStorage(shopDao);
        shop = new FruitShop(storage, shopDao);
        
        int index = 0;
        while (shop.getShopStorage().containsKey(new Fruit("Fruit" + index))) {
            index++;
        }
        Fruit newFruit1 = new Fruit("Fruit" + index);
        Fruit newFruit2 = new Fruit("Fruit" + (index + 1));
        
        shop.performAction(ShopTransactionsTypes.BALANCE, newFruit1, 100);
        shop.performAction(ShopTransactionsTypes.SUPPLY, newFruit2, 100);
        assertTrue(shop.getShopStorage().containsKey(newFruit1));
        assertTrue(shop.getShopStorage().containsKey(newFruit2));
    }
    
    @Test
    public void shopReturnProduct() {
        shopDao = new FruitShopDao(testDatabase);
        storage = new FruitShopStorage(shopDao);
        shop = new FruitShop(storage, shopDao);
        Fruit fruit3 = new Fruit("Fruit3");
        
        
        int actual = shop.getShopStorage().get(fruit3);
        int expectedDifference = 5;
        
        shop.performAction(ShopTransactionsTypes.RETURN, fruit3, expectedDifference);
        actual = shop.getShopStorage().get(fruit3) - actual;
        assertEquals(expectedDifference, actual);
    }
}

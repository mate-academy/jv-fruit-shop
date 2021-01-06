package core.basesyntax.shopimpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import core.basesyntax.model.AbstractShop;
import core.basesyntax.model.abstractstorage.AbstractStorage;
import core.basesyntax.model.shopdao.ShopDto;
import core.basesyntax.model.shopstrategy.ShopTransactionsType;
import core.basesyntax.shopimpl.database.FruitShopDto;
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
    private ShopDto<DataRecord> shopDto;
    private AbstractStorage<DataRecord, Fruit> storage;
    
    @Test
    public void emptyFileStorageInit() {
        shopDto = new FruitShopDto(emptyFilePath);
        storage = new FruitShopStorage(shopDto);
        int actual = storage.getStorage().size();
        int expected = 0;
        assertEquals(expected, actual);
    }
    
    @Test(expected = IllegalStateException.class)
    public void illegalEntryFileStorageInit() {
        shopDto = new FruitShopDto(illegalEntryFilePath);
        storage = new FruitShopStorage(shopDto);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentFileStorageInit() {
        shopDto = new FruitShopDto(illegalArgumentFilePath);
        storage = new FruitShopStorage(shopDto);
    }
    
    @Test
    public void severalFruitsStorageInit() {
        shopDto = new FruitShopDto(severalFruitsFilePath);
        storage = new FruitShopStorage(shopDto);
        
        int actual = storage.getStorage().size();
        int expected = 4;
        assertEquals(expected, actual);
        DataRecord expectedRecord = new DataRecord(ShopTransactionsType.BALANCE,
                new Fruit("Fruit"),
                100);
        assertTrue(shopDto.getTransactionHistory().contains(expectedRecord));
        assertTrue(storage.getStorage().containsKey(expectedRecord.getItem()));
    }
    
    @Test
    public void severalFruitsAndActionsStorageInit() {
        shopDto = new FruitShopDto(getSeveralFruitsAndActionFilePath);
        storage = new FruitShopStorage(shopDto);
        
        int actualAmountFruit1 = storage.getStorage().get(new Fruit("Fruit1"));
        int expectedAmountFruit1 = 80;
        assertEquals(expectedAmountFruit1, actualAmountFruit1);
    }
    
    @Test(expected = RuntimeException.class)
    public void shopPurchaseExceptionExpected() {
        shopDto = new FruitShopDto(testDatabase);
        storage = new FruitShopStorage(shopDto);
        shop = new FruitShop(storage, shopDto);
        
        shop.performAction(ShopTransactionsType.PURCHASE, new Fruit("Fruit1"), 1000);
    }
    
    @Test
    public void shopPurchase() {
        shopDto = new FruitShopDto(testDatabase);
        storage = new FruitShopStorage(shopDto);
        shop = new FruitShop(storage, shopDto);
        Fruit fruit3 = new Fruit("Fruit3");
        
        int actual = shop.getShopStorage().get(fruit3);
        int expectedDifference = 5;
        
        shop.performAction(ShopTransactionsType.PURCHASE, fruit3, expectedDifference);
        actual = actual - shop.getShopStorage().get(fruit3);
        assertEquals(expectedDifference, actual);
    }
    
    @Test
    public void shopAddNewProduct() {
        shopDto = new FruitShopDto(testDatabase);
        storage = new FruitShopStorage(shopDto);
        shop = new FruitShop(storage, shopDto);
        
        int index = 0;
        while (shop.getShopStorage().containsKey(new Fruit("Fruit" + index))) {
            index++;
        }
        Fruit newFruit1 = new Fruit("Fruit" + index);
        Fruit newFruit2 = new Fruit("Fruit" + (index + 1));
        
        shop.performAction(ShopTransactionsType.BALANCE, newFruit1, 100);
        shop.performAction(ShopTransactionsType.SUPPLY, newFruit2, 100);
        assertTrue(shop.getShopStorage().containsKey(newFruit1));
        assertTrue(shop.getShopStorage().containsKey(newFruit2));
    }
    
    @Test
    public void shopSupplyProduct() {
        shopDto = new FruitShopDto(testDatabase);
        storage = new FruitShopStorage(shopDto);
        shop = new FruitShop(storage, shopDto);
        Fruit fruit3 = new Fruit("Fruit3");
    
        int actual = shop.getShopStorage().get(fruit3);
        int expectedDifference = 50;
    
        shop.performAction(ShopTransactionsType.SUPPLY, fruit3, expectedDifference);
        actual = shop.getShopStorage().get(fruit3) - actual;
        assertEquals(expectedDifference, actual);
    }
    
    @Test
    public void shopReturnProduct() {
        shopDto = new FruitShopDto(testDatabase);
        storage = new FruitShopStorage(shopDto);
        shop = new FruitShop(storage, shopDto);
        Fruit fruit3 = new Fruit("Fruit3");
        
        int actual = shop.getShopStorage().get(fruit3);
        int expectedDifference = 5;
        
        shop.performAction(ShopTransactionsType.RETURN, fruit3, expectedDifference);
        actual = shop.getShopStorage().get(fruit3) - actual;
        assertEquals(expectedDifference, actual);
    }
    
    @Test(expected = RuntimeException.class)
    public void nullTestOnShopDaoArgument() {
        shopDto = new FruitShopDto(null);
    }
    
    @Test(expected = RuntimeException.class)
    public void nullTestOnShopStorageArgument() {
        storage = new FruitShopStorage(null);
    }
    
    @Test(expected = RuntimeException.class)
    public void nullTestOnShopConstructorArguments() {
        shop = new FruitShop(storage, shopDto);
    }
    
    @Test(expected = RuntimeException.class)
    public void nullTestOnShopPerformActionArguments() {
        shopDto = new FruitShopDto(testDatabase);
        storage = new FruitShopStorage(shopDto);
        shop = new FruitShop(storage, shopDto);
        shop.performAction(ShopTransactionsType.RETURN, null, 0);
    }
    
    @Test(expected = RuntimeException.class)
    public void nullTestOnShopPerformActionArguments2() {
        shopDto = new FruitShopDto(testDatabase);
        storage = new FruitShopStorage(shopDto);
        shop = new FruitShop(storage, shopDto);
        shop.performAction(null, new Fruit("Some"), 0);
    }
}

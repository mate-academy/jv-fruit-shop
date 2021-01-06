package core.basesyntax.shopimpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.model.abstractstorage.AbstractStorage;
import core.basesyntax.model.shopstrategy.ShopTransactionsType;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.entity.Fruit;
import core.basesyntax.shopimpl.service.IOdataFileService;
import core.basesyntax.shopimpl.storage.FruitShopStorage;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class FruitShopTest {
    private AbstractStorage<DataRecord, AbstractItem> storage = new FruitShopStorage();
    private static final IOdataFileService fileService = new IOdataFileService();
    private static final List<DataRecord> emptyList = Collections.emptyList();
    private static final List<DataRecord> illegalDataRecord
            = List.of(new DataRecord(ShopTransactionsType.RETURN,
            new Fruit("fruit"),
            -10));
    
    @Test
    public void emptyFileStorageInit() {
        storage.initStorage(emptyList);
        int actual = storage.getStorage().size();
        int expected = 0;
        assertEquals(expected, actual);
    }
    
    @Test(expected = IllegalStateException.class)
    public void illegalEntryFileStorageInit() {
        storage.getStorage().clear();
        storage.initStorage(illegalDataRecord);
    }
    
    @Test
    public void severalFruitsStorageInit() {
        List<String> lines
                = fileService.readFile("src/test/resources/SeveralFruitsDatabase.csv");
        List<DataRecord> records = fileService.parseAll(lines);
        storage.getStorage().clear();
        storage.initStorage(records);
        
        int actual = storage.getStorage().size();
        int expected = 4;
        assertEquals(expected, actual);
        DataRecord expectedRecord = new DataRecord(ShopTransactionsType.BALANCE,
                new Fruit("Fruit"),
                100);
        assertTrue(storage.getStorage().containsKey(expectedRecord.getItem()));
    }
    
    @Test
    public void severalFruitsAndActionsStorageInit() {
        List<String> lines = fileService
                .readFile("src/test/resources/SeveralFruitsAndActionsTestDatabase.csv");
        List<DataRecord> records = fileService.parseAll(lines);
        storage.getStorage().clear();
        storage.initStorage(records);

        int actualAmountFruit1 = storage.getStorage().get(new Fruit("Fruit1"));
        int expectedAmountFruit1 = 80;
        assertEquals(expectedAmountFruit1, actualAmountFruit1);
    }
    
    @Test(expected = RuntimeException.class)
    public void shopPurchaseExceptionExpected() {
        List<String> lines = fileService
                .readFile("src/test/resources/purchaseExceptionExpected.csv");
        List<DataRecord> records = fileService.parseAll(lines);
        storage.getStorage().clear();
        storage.initStorage(records);
    }
    
    @Test
    public void shopPurchase() {
        String path = "src/test/resources/purchaseValid.csv";
        List<String> lines = fileService.readFile(path);
        List<DataRecord> records = fileService.parseAll(lines);
        storage.getStorage().clear();
        storage.initStorage(records);

        Fruit fruit3 = new Fruit("Fruit");

        int actual = storage.getStorage().get(fruit3);
        int expectedAmount = 80;
        assertEquals(expectedAmount, actual);
    }
    
    @Test
    public void shopAddNewProduct() {
        //TODO finish refactoring of the method and all of below methods as well
        String path = "src/test/resources/purchaseValid.csv";
        List<String> lines = fileService.readFile(path);
        List<DataRecord> records = fileService.parseAll(lines);
        storage.getStorage().clear();
        storage.initStorage(records);
    
        Fruit fruit3 = new Fruit("Fruit");
    
        int actual = storage.getStorage().get(fruit3);
        int expectedAmount = 80;
        assertEquals(expectedAmount, actual);
    }
    
    @Test
    public void shopSupplyProduct() {
//        shopDto = new FruitShopDto(testDatabase);
//        storage = new FruitShopStorage(shopDto);
//        shop = new FruitShop(storage, shopDto);
//        Fruit fruit3 = new Fruit("Fruit3");
//
//        int actual = shop.getShopStorage().get(fruit3);
//        int expectedDifference = 50;
//
//        shop.performAction(ShopTransactionsType.SUPPLY, fruit3, expectedDifference);
//        actual = shop.getShopStorage().get(fruit3) - actual;
//        assertEquals(expectedDifference, actual);
    }
    
    @Test
    public void shopReturnProduct() {
//        shopDto = new FruitShopDto(testDatabase);
//        storage = new FruitShopStorage(shopDto);
//        shop = new FruitShop(storage, shopDto);
//        Fruit fruit3 = new Fruit("Fruit3");
//
//        int actual = shop.getShopStorage().get(fruit3);
//        int expectedDifference = 5;
//
//        shop.performAction(ShopTransactionsType.RETURN, fruit3, expectedDifference);
//        actual = shop.getShopStorage().get(fruit3) - actual;
//        assertEquals(expectedDifference, actual);
    }
    
    @Test(expected = RuntimeException.class)
    public void nullTestOnShopDaoArgument() {
//        shopDto = new FruitShopDto(null);
    }
    
    @Test(expected = RuntimeException.class)
    public void nullTestOnShopStorageArgument() {
//        storage = new FruitShopStorage(null);
    }
    
    @Test(expected = RuntimeException.class)
    public void nullTestOnShopConstructorArguments() {
//        shop = new FruitShop(storage, shopDto);
    }
    
    @Test(expected = RuntimeException.class)
    public void nullTestOnShopPerformActionArguments() {
//        shopDto = new FruitShopDto(testDatabase);
//        storage = new FruitShopStorage(shopDto);
//        shop = new FruitShop(storage, shopDto);
//        shop.performAction(ShopTransactionsType.RETURN, null, 0);
    }
    
    @Test(expected = RuntimeException.class)
    public void nullTestOnShopPerformActionArguments2() {
//        shopDto = new FruitShopDto(testDatabase);
//        storage = new FruitShopStorage(shopDto);
//        shop = new FruitShop(storage, shopDto);
//        shop.performAction(null, new Fruit("Some"), 0);
    }
}

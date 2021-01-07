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
import org.junit.Test;

public class FruitShopTest {
    private static final List<DataRecord> emptyList = Collections.emptyList();
    private static final IOdataFileService fileService = new IOdataFileService();
    private static final List<DataRecord> illegalDataRecord
            = List.of(new DataRecord(ShopTransactionsType.RETURN,
            new Fruit("fruit"),
            -10));
    private AbstractStorage<DataRecord, AbstractItem> storage = new FruitShopStorage();
    
    @Test
    public void emptyFileStorageInit() {
        storage.performTransactions(emptyList);
        int actual = storage.getStorage().size();
        int expected = 0;
        assertEquals(expected, actual);
    }
    
    @Test(expected = IllegalStateException.class)
    public void illegalEntryFileStorageInit() {
        storage.getStorage().clear();
        storage.performTransactions(illegalDataRecord);
    }
    
    @Test
    public void severalFruitsStorageInit() {
        List<String> lines
                = fileService.readFile("src/test/resources/SeveralFruitsDatabase.csv");
        List<DataRecord> records = fileService.parseAll(lines);
        storage.getStorage().clear();
        storage.performTransactions(records);
        
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
        storage.performTransactions(records);

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
        storage.performTransactions(records);
    }
    
    @Test
    public void shopPurchase() {
        String path = "src/test/resources/purchaseValid.csv";
        List<String> lines = fileService.readFile(path);
        List<DataRecord> records = fileService.parseAll(lines);
        storage.getStorage().clear();
        storage.performTransactions(records);

        Fruit fruit3 = new Fruit("Fruit");

        int actual = storage.getStorage().get(fruit3);
        int expectedAmount = 80;
        assertEquals(expectedAmount, actual);
    }
    
    @Test
    public void shopAddNewProduct() {
        String path = "src/test/resources/addProductTestFile.csv";
        List<String> lines = fileService.readFile(path);
        List<DataRecord> records = fileService.parseAll(lines);
        storage.getStorage().clear();
        storage.performTransactions(records);
    
        Fruit fruit1 = new Fruit("Fruit");
        Fruit fruit2 = new Fruit("Fruit1");
        Fruit fruit3 = new Fruit("Fruit2");
    
        int actualFruit1 = storage.getStorage().get(fruit1);
        int actualFruit2 = storage.getStorage().get(fruit2);
        int actualFruit3 = storage.getStorage().get(fruit3);
        int expected1 = 100;
        int expected2 = 200;
        int expected3 = 50;
        
        assertEquals(expected1, actualFruit1);
        assertEquals(expected2, actualFruit2);
        assertEquals(expected3, actualFruit3);
    }
    
    @Test
    public void shopReturnProductValid() {
        String path = "src/test/resources/returnValid.csv";
        List<String> lines = fileService.readFile(path);
        List<DataRecord> records = fileService.parseAll(lines);
        storage.getStorage().clear();
        storage.performTransactions(records);
        
        Fruit fruit = new Fruit("Fruit");
        
        int actual = storage.getStorage().get(fruit);
        int expected = 100;
        
        assertEquals(expected, actual);
    }
    
    @Test(expected = RuntimeException.class)
    public void nullTestDataRecord() {
        new DataRecord(null, new Fruit("some"), 10);
    }
    
    @Test(expected = RuntimeException.class)
    public void nullTestFruit() {
        new Fruit(null);
    }
    
    @Test(expected = RuntimeException.class)
    public void nullTestOnPerformActionArgument() {
        storage.performTransactions(null);
    }
}

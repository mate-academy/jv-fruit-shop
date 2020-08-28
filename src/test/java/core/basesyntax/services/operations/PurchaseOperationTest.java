package core.basesyntax.services.operations;

import core.basesyntax.services.FruitDto;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class PurchaseOperationTest {
    private static Map<String, Map<String, Integer>> store;
    private static Map<String, Integer> bananaEntity;
    private FruitDto dto;

    @BeforeClass
    public static void beforeClass(){
        store = new HashMap<>();
        bananaEntity = new HashMap<>();
    }

    @Test
    public void normalConditions() {
        dto = new FruitDto( "b", "banana", 20, "2020-10-15" );
        bananaEntity.put("2020-10-17", 100);
        store.put("banana", bananaEntity);
        PurchaseOperation purchaseOperation = new PurchaseOperation();
        boolean result = purchaseOperation.updateStorage(store, dto);
        Assert.assertTrue(result);
        Assert.assertSame( 80, store.get("banana").get("2020-10-17"));
        Assert.assertEquals(1, store.size());
    }

    @Test
    public void buyAllAvailable() {
        dto = new FruitDto("b", "banana", 10, "2020-10-15" );
        bananaEntity.put("2020-10-17", 10);
        store.put("banana", bananaEntity);
        PurchaseOperation purchaseOperation = new PurchaseOperation();
        boolean result = purchaseOperation.updateStorage(store, dto);
        Assert.assertTrue(result);
        Assert.assertSame( 0, store.get("banana").get("2020-10-17"));
        Assert.assertEquals(1, store.size());
    }

    @Test
    public void buyMoreThenAvailable() {
        dto = new FruitDto("b", "banana", 20, "2020-10-15");
        bananaEntity.put("2020-10-17", 10);
        store.put("banana", bananaEntity);
        PurchaseOperation purchaseOperation = new PurchaseOperation();
        boolean result = purchaseOperation.updateStorage(store, dto);
        Assert.assertFalse(result);
        Assert.assertSame( 10, store.get("banana").get("2020-10-17"));
        Assert.assertEquals(1, store.size());
    }

    @Test
    public void buyWithDifferentExpirationDates() {
        dto = new FruitDto("b", "banana", 10, "2020-10-15");
        bananaEntity.put("2020-10-17", 5);
        bananaEntity.put("2020-10-18", 10);
        store.put("banana", bananaEntity);
        PurchaseOperation purchaseOperation = new PurchaseOperation();
        boolean result = purchaseOperation.updateStorage(store, dto);
        Assert.assertTrue(result);
        Assert.assertSame( 5, store.get("banana").get("2020-10-18"));
        Assert.assertEquals(1, store.size());
    }

    @Test
    public void buyAbsentFruit() {
        dto = new FruitDto("b", "orange", 10, "2020-10-15");
        bananaEntity.put("2020-10-18", 10);
        store.put("banana", bananaEntity);
        PurchaseOperation purchaseOperation = new PurchaseOperation();
        boolean result = purchaseOperation.updateStorage(store, dto);
        Assert.assertFalse(result);
        Assert.assertSame( 10, store.get("banana").get("2020-10-18"));
        Assert.assertEquals(1, store.size());
    }
}

package core.basesyntax.services.operations;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class PurchaseOperationTest {
    private static Map<String, Map<String, Integer>> store;
    private static Map<String, Integer> bananaEntity;

    @BeforeClass
    public static void before(){
        store = new HashMap<>();
        bananaEntity = new HashMap<>();
    }

    @Test
    public void testNormalConditionsBuy() {
        String[] data = new String[]{"b", "banana", "20", "2020-10-15" };
        bananaEntity.put("2020-10-17", 100);
        store.put("banana", bananaEntity);
        PurchaseOperation purchaseOperation = new PurchaseOperation();
        boolean result = purchaseOperation.updateStorage(store, data);
        Assert.assertTrue(result);
        Assert.assertSame( 80, store.get("banana").get("2020-10-17"));
        Assert.assertEquals(1, store.size());
    }

    @Test
    public void testBuyAll() {
        String[] data = new String[]{"b", "banana", "10", "2020-10-15" };
        bananaEntity.put("2020-10-17", 10);
        store.put("banana", bananaEntity);
        PurchaseOperation purchaseOperation = new PurchaseOperation();
        boolean result = purchaseOperation.updateStorage(store, data);
        Assert.assertTrue(result);
        Assert.assertSame( 0, store.get("banana").get("2020-10-17"));
        Assert.assertEquals(1, store.size());
    }

    @Test
    public void testBuyMore() {
        String[] data = new String[]{"b", "banana", "20", "2020-10-15" };
        bananaEntity.put("2020-10-17", 10);
        store.put("banana", bananaEntity);
        PurchaseOperation purchaseOperation = new PurchaseOperation();
        boolean result = purchaseOperation.updateStorage(store, data);
        Assert.assertFalse(result);
        Assert.assertSame( 10, store.get("banana").get("2020-10-17"));
        Assert.assertEquals(1, store.size());
    }

    @Test
    public void testBuyWithDifferentExpirationDates() {
        String[] data = new String[]{"b", "banana", "10", "2020-10-15" };
        bananaEntity.put("2020-10-17", 5);
        bananaEntity.put("2020-10-18", 10);
        store.put("banana", bananaEntity);
        PurchaseOperation purchaseOperation = new PurchaseOperation();
        boolean result = purchaseOperation.updateStorage(store, data);
        Assert.assertTrue(result);
        Assert.assertSame( 5, store.get("banana").get("2020-10-18"));
        Assert.assertEquals(1, store.size());
    }

    @Test
    public void testBuyAbsentFruit() {
        String[] data = new String[]{"b", "orange", "10", "2020-10-15" };
        bananaEntity.put("2020-10-18", 10);
        store.put("banana", bananaEntity);
        PurchaseOperation purchaseOperation = new PurchaseOperation();
        boolean result = purchaseOperation.updateStorage(store, data);
        Assert.assertFalse(result);
        Assert.assertSame( 10, store.get("banana").get("2020-10-18"));
        Assert.assertEquals(1, store.size());
    }
}

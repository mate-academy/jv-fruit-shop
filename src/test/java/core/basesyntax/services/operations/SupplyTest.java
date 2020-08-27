package core.basesyntax.services.operations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class SupplyTest{
    private static final  String[] BANANAS_20
            = new String[]{"s", "banana", "20", "2020-10-15" };
    private static final  String[] BANANAS_10
            = new String[]{"s", "banana", "10", "2020-10-15" };
    private static Map<String, Map<String, Integer>> store;
    private static Supply supply;


    @BeforeClass
    public static void before(){
        store = new HashMap<>();
        supply = new Supply();
    }

    @Before
    public void beforeEach(){
        store = new HashMap<>();
    }

    @Test
    public void supplyNormalConditionsTest(){
        boolean result = supply.operate(store, BANANAS_20);
        Assert.assertTrue(result);
        Assert.assertEquals(1, store.size());
        Assert.assertSame( 20, store.get("banana").get("2020-10-15"));
    }

    @Test
    public void supplyDifferentFruitsTest(){
        String[] dataOranges = new String[]{"s", "orange", "50", "2020-10-18" };

        boolean resultBananas = supply.operate(store, BANANAS_20);
        boolean resultOranges = supply.operate(store, dataOranges);
        Assert.assertTrue(resultBananas);
        Assert.assertTrue(resultOranges);
        Assert.assertEquals(2, store.size());
        Assert.assertSame( 20, store.get("banana").get("2020-10-15"));
        Assert.assertSame( 50, store.get("orange").get("2020-10-18"));
    }

    @Test
    public void supplyDifferentDatesTest(){
        String[] data = new String[]{"s", "banana", "20", "2020-10-20" };
        boolean result10 = supply.operate(store, BANANAS_10);
        boolean result20 = supply.operate(store, data);
        Assert.assertTrue(result10);
        Assert.assertTrue(result20);
        Assert.assertEquals(1, store.size());
        Assert.assertEquals(2, store.get("banana").size());
    }

    @Test
    public void supplyIncreaseFruitsCountTest(){
        boolean firstSupplyResult = supply.operate(store, BANANAS_10);
        boolean secondSupplyResult = supply.operate(store, BANANAS_10);
        Assert.assertTrue(firstSupplyResult);
        Assert.assertTrue(secondSupplyResult);
        Assert.assertEquals(1, store.size());
        Assert.assertEquals(1, store.get("banana").size());
        Assert.assertSame(20, store.get("banana").get("2020-10-15"));
    }
}

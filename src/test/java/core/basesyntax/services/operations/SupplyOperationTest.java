package core.basesyntax.services.operations;

import core.basesyntax.services.FruitDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class SupplyOperationTest {
    private static final FruitDto DTO_SUPPLY_20_BANANAS
            = new FruitDto("s", "banana", 20, "2020-10-15");
    private static final FruitDto DTO_SUPPLY_10_BANANAS
            = new FruitDto("s", "banana", 10, "2020-10-15");
    private static Map<String, Map<String, Integer>> store;
    private static SupplyOperation supplyOperation;


    @BeforeClass
    public static void beforeClass(){
        store = new HashMap<>();
        supplyOperation = new SupplyOperation();
    }

    @Before
    public void beforeEach(){
        store = new HashMap<>();
    }

    @Test
    public void supplyNormalConditionsTest(){
        boolean result = supplyOperation.updateStorage(store, DTO_SUPPLY_20_BANANAS);
        Assert.assertTrue(result);
        Assert.assertEquals(1, store.size());
        Assert.assertSame( 20, store.get("banana").get("2020-10-15"));
    }

    @Test
    public void supplyDifferentFruitsTest(){
        FruitDto dtoOranges = new FruitDto("s", "orange", 50, "2020-10-18");

        boolean resultBananas = supplyOperation.updateStorage(store, DTO_SUPPLY_20_BANANAS);
        boolean resultOranges = supplyOperation.updateStorage(store, dtoOranges);
        Assert.assertTrue(resultBananas);
        Assert.assertTrue(resultOranges);
        Assert.assertEquals(2, store.size());
        Assert.assertSame( 20, store.get("banana").get("2020-10-15"));
        Assert.assertSame( 50, store.get("orange").get("2020-10-18"));
    }

    @Test
    public void supplyDifferentDatesTest(){
        FruitDto dtoWithOtherDate = new FruitDto("s", "banana", 20, "2020-10-20" );
        boolean result10 = supplyOperation.updateStorage(store, DTO_SUPPLY_10_BANANAS);
        boolean result20 = supplyOperation.updateStorage(store, dtoWithOtherDate);
        Assert.assertTrue(result10);
        Assert.assertTrue(result20);
        Assert.assertEquals(1, store.size());
        Assert.assertEquals(2, store.get("banana").size());
    }

    @Test
    public void supplyIncreaseFruitsCountTest(){
        boolean firstSupplyResult = supplyOperation.updateStorage(store, DTO_SUPPLY_10_BANANAS);
        boolean secondSupplyResult = supplyOperation.updateStorage(store, DTO_SUPPLY_10_BANANAS);
        Assert.assertTrue(firstSupplyResult);
        Assert.assertTrue(secondSupplyResult);
        Assert.assertEquals(1, store.size());
        Assert.assertEquals(1, store.get("banana").size());
        Assert.assertSame(20, store.get("banana").get("2020-10-15"));
    }
}

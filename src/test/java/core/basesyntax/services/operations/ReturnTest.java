package core.basesyntax.services.operations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class ReturnTest{
    private static Map<String, Map<String, Integer>> store;
    private static String[] data;
    private static Return ret;

    @Before
    public void before(){
        store = new HashMap<>();
        data = new String[]{"r", "banana", "10", "2020-10-15" };
        ret = new Return();
    }


    @Test
    public void returnTest(){
        boolean result = ret.operate(store, data);
        Assert.assertTrue(result);
        Assert.assertEquals(1, store.size());
        Assert.assertSame( 10, store.get("banana").get("2020-10-15"));
    }

    @Test
    public void returnSameFruitTest(){
        boolean firstResult = ret.operate(store, data);
        boolean secondResult = ret.operate(store, data);
        Assert.assertTrue(firstResult);
        Assert.assertTrue(secondResult);
        Assert.assertEquals(1, store.size());
        Assert.assertSame( 20, store.get("banana").get("2020-10-15"));
    }

    @Test
    public void returnSameFruitDifferentDatesTest(){
        String[] data20 = new String[]{"r", "banana", "20", "2020-10-20" };

        boolean firstResult = ret.operate(store, data);
        boolean secondResult = ret.operate(store, data20);
        Assert.assertTrue(firstResult);
        Assert.assertTrue(secondResult);
        Assert.assertEquals(1, store.size());
        Assert.assertEquals(2, store.get("banana").size());
        Assert.assertSame( 10, store.get("banana").get("2020-10-15"));
        Assert.assertSame( 20, store.get("banana").get("2020-10-20"));
    }
}
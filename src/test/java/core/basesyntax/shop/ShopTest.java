package core.basesyntax.shop;

import core.basesyntax.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.shop.impl.BuyTradingImpl;
import core.basesyntax.shop.impl.RefundsTradingImpl;
import core.basesyntax.shop.impl.SupplyTradingImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ShopTest {
    private static final Fruit BANANA_FRUIT = new Fruit("banana", LocalDate.now());
    private Shop shop;

    @Before
    public void before() {
        Storage storage = new Storage();
        Map<String, Trading> tradingMap = new HashMap<>();
        tradingMap.put("s", new SupplyTradingImpl(storage));
        tradingMap.put("b", new BuyTradingImpl(storage));
        tradingMap.put("r", new RefundsTradingImpl(storage));
        shop = new Shop(tradingMap, storage);
    }

    @Test(expected = RuntimeException.class)
    public void tradeNullTest() {
        shop.trade(null, null, 0);
    }

    @Test(expected = RuntimeException.class)
    public void tradingNullTest() {
        shop.trade("q", BANANA_FRUIT, 100);
    }

    @Test
    public void tradingCorrectTest() {
        shop.trade("s", BANANA_FRUIT, 100);
        int actualSizeBalanceStorage = shop.balanceStorage().size();
        Assert.assertEquals(1, actualSizeBalanceStorage);
    }

    @Test
    public void emptyBalanceStorageTest() {
        int actual = shop.balanceStorage().size();
        Assert.assertEquals(0, actual);
    }
}

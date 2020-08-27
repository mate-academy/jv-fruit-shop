package core.basesyntax.service;

import core.basesyntax.Storage;
import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.impl.FruitParserImpl;
import core.basesyntax.shop.Shop;
import core.basesyntax.shop.Trading;
import core.basesyntax.shop.impl.BuyTradingImpl;
import core.basesyntax.shop.impl.RefundsTradingImpl;
import core.basesyntax.shop.impl.SupplyTradingImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceTest {
    private static ShopService shopService;
    private static Storage storage;

    @BeforeClass
    public static void setup() {
        storage = new Storage();
        Map<String, Trading> tradingMap = new HashMap<>();
        tradingMap.put("s", new SupplyTradingImpl(storage));
        tradingMap.put("b", new BuyTradingImpl(storage));
        tradingMap.put("r", new RefundsTradingImpl(storage));
        Shop shop = new Shop(tradingMap, storage);
        FruitParser fruitParser = new FruitParserImpl();
        List<FruitDto> data = List.of(
                new FruitDto("s", "banana", 100, LocalDate.now()),
                new FruitDto("s", "banana", 50, LocalDate.now()),
                new FruitDto("r", "banana", 10, LocalDate.now()),
                new FruitDto("s", "orange", 200, LocalDate.now()),
                new FruitDto("b", "banana", 100, LocalDate.now()));
        shopService = new ShopService(shop, fruitParser, data);
    }

    @Test
    public void precessWaybillTest() {
        shopService.precessWaybill();
        List<Storage.FruitBox> actual = storage.getAll();
        List<Storage.FruitBox> expected = List.of(
                new Storage.FruitBox(new Fruit("banana", LocalDate.now()), 60),
                new Storage.FruitBox(new Fruit("orange", LocalDate.now()), 200));
        Assert.assertEquals(expected, actual);
    }
}

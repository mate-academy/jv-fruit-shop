package core.basesyntax.shop.implementation;

import static org.junit.jupiter.api.Assertions.assertTrue;

import core.basesyntax.shop.ShopService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ShopServiceImplTest {
    private static ShopService shopService;
    private static List<String> stringList;

    @BeforeAll
    static void beforeAll() {
        shopService = new ShopServiceImpl();
        stringList = new ArrayList<>();
        stringList.add("b,apple,100");
    }

    @Test
    void pushDataToStorage_OK() {

        assertTrue(shopService.pushDataToStorage(stringList));
    }
}

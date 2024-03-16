package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import org.junit.jupiter.api.Test;

class ShopTest {

    private static final String APPLE = "apple";
    private static final String BANANA = "banana";

    @Test
    void supplyTest() {
        Shop shop = new Shop();
        assertTrue(shop.getFruits().isEmpty());

        shop.supplyFruits(APPLE, 5);
        assertEquals(Set.of(APPLE), shop.getFruits());
        assertEquals(5, shop.getFruitsQuantity(APPLE));

        shop.supplyFruits(APPLE, 3);
        assertEquals(8, shop.getFruitsQuantity(APPLE));

        shop.supplyFruits(BANANA, 100);
        assertEquals(Set.of(BANANA, APPLE), shop.getFruits());
        assertEquals(100, shop.getFruitsQuantity(BANANA));
    }
}

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

        shop.fruitsBalance(APPLE, 5);
        assertEquals(Set.of(APPLE), shop.getFruits());
        assertEquals(5, shop.getFruitsQuantity(APPLE));

        shop.addFruits(APPLE, 3);
        assertEquals(8, shop.getFruitsQuantity(APPLE));

        shop.fruitsBalance(BANANA, 100);
        assertEquals(Set.of(BANANA, APPLE), shop.getFruits());
        assertEquals(100, shop.getFruitsQuantity(BANANA));

        shop.removeFruits(APPLE, 5);
        assertEquals(3, shop.getFruitsQuantity(APPLE));

        shop.removeFruits(BANANA, 50);
        assertEquals(50, shop.getFruitsQuantity(BANANA));
    }
}

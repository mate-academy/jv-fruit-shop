package core.basesyntax.transaction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.db.ShopStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShopTransactionTest {

    private ShopTransaction transaction;

    @BeforeEach
    void setUp() {
        transaction = new ShopTransaction(new ShopStorage());
    }

    private String uniqueKey() {
        return "item_" + System.nanoTime();
    }

    @Test
    void init_ShouldCreateItem_WhenValidInput() {
        String key = uniqueKey();
        Integer result = transaction.init(key, 10);
        assertEquals(10, result);
        assertEquals(10, transaction.get(key));
    }

    @Test
    void init_ShouldThrow_WhenItemAlreadyExists() {
        String key = uniqueKey();
        transaction.init(key, 10);
        assertThrows(IllegalStateException.class,
                () -> transaction.init(key, 20));
    }

    @Test
    void init_ShouldThrow_WhenItemIsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> transaction.init(null, 10));
    }

    @Test
    void init_ShouldThrow_WhenQuantityIsNull() {
        String key = uniqueKey();

        assertThrows(IllegalArgumentException.class,
                () -> transaction.init(key, null));
    }

    @Test
    void init_ShouldThrow_WhenQuantityNegative() {
        String key = uniqueKey();

        assertThrows(IllegalArgumentException.class,
                () -> transaction.init(key, -5));
    }

    @Test
    void add_ShouldIncreaseQuantity() {
        String key = uniqueKey();
        transaction.init(key, 10);
        Integer result = transaction.add(key, 5);
        assertEquals(15, result);
        assertEquals(15, transaction.get(key));
    }

    @Test
    void add_ShouldThrow_WhenItemNotExists() {
        String key = uniqueKey();

        assertThrows(IllegalArgumentException.class,
                () -> transaction.add(key, 5));
    }

    @Test
    void subtract_ShouldDecreaseQuantity() {
        String key = uniqueKey();
        transaction.init(key, 10);
        Integer result = transaction.subtract(key, 3);
        assertEquals(7, result);
    }

    @Test
    void subtract_ShouldThrow_WhenResultNegative() {
        String key = uniqueKey();
        transaction.init(key, 5);
        assertThrows(IllegalStateException.class,
                () -> transaction.subtract(key, 10));
    }

    @Test
    void get_ShouldReturnNull_WhenItemNotExists() {
        String key = uniqueKey();
        assertNull(transaction.get(key));
    }
}

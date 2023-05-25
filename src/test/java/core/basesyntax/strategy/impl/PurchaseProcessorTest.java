package core.basesyntax.strategy.impl;

import static core.basesyntax.model.Product.APPLE;
import static core.basesyntax.model.Product.BANANA;
import static core.basesyntax.strategy.FruitTransaction.Operation.PURCHASE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.exeptions.InvalidTransaction;
import core.basesyntax.model.Product;
import core.basesyntax.strategy.FruitTransaction;
import core.basesyntax.strategy.OperationProcessor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@DisplayName("PurchaseProcessor Test")
class PurchaseProcessorTest {
    private final ProductDao<Product, Integer> dao = new ProductDaoImpl();
    private final OperationProcessor purchaseProcessor =
            new PurchaseProcessor(new ProductDaoImpl());

    @AfterEach
    void tearDown() {
        dao.clear();
    }

    @DisplayName("Check purchase operation with valid value (Apple)")
    @Order(1)
    @Test
    void operate_checkPurchaseAppleEmptyStorage_ok() {
        dao.put(APPLE, 15);
        purchaseProcessor.operate(new FruitTransaction(PURCHASE, APPLE, 10));
        assertEquals(dao.get(APPLE), 5);
        purchaseProcessor.operate(new FruitTransaction(PURCHASE, APPLE, 5));
        assertEquals(dao.get(APPLE), 0);
    }

    @DisplayName("Check purchase operation with valid value (Apple) and empty Storage")
    @Order(2)
    @Test
    void operate_checkPurchaseApple_NotOk() {
        assertThrows(RuntimeException.class,
                () -> purchaseProcessor.operate(new FruitTransaction(PURCHASE, APPLE, 20)));
    }

    @DisplayName("Check purchase operation with valid value (Banana)")
    @Order(3)
    @Test
    void operate_checkPurchaseBananaEmptyStorage_ok() {
        dao.put(BANANA, 147);
        purchaseProcessor.operate(new FruitTransaction(PURCHASE, BANANA, 130));
        assertEquals(dao.get(BANANA), 17);
        purchaseProcessor.operate(new FruitTransaction(PURCHASE, BANANA, 17));
        assertEquals(dao.get(BANANA), 0);
    }

    @DisplayName("Check purchase operation with valid value (Banana) and empty Storage")
    @Order(4)
    @Test
    void operate_checkPurchaseBananaEmpty_notOk() {
        assertThrows(InvalidTransaction.class,
                () -> purchaseProcessor.operate(new FruitTransaction(PURCHASE, BANANA, 128)));
    }

    @DisplayName("Check purchase operation with invalid value (Apple) and non empty Storage")
    @Order(5)
    @Test
    void operate_checkPurchaseBananaIncorrect_notOk() {
        dao.put(BANANA, 147);
        assertThrows(InvalidTransaction.class,
                () -> purchaseProcessor.operate(new FruitTransaction(PURCHASE, BANANA, -15)));
    }

    @DisplayName("Check purchase operation with invalid value (Apple) and non empty Storage")
    @Order(6)
    @Test
    void operate_checkPurchaseApple_notOk() {
        dao.put(BANANA, 147);
        assertThrows(InvalidTransaction.class,
                () -> purchaseProcessor.operate(new FruitTransaction(PURCHASE, APPLE, -18)));
    }
}

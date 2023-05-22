package core.basesyntax.strategy.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.model.Product;
import core.basesyntax.strategy.FruitTransaction;
import core.basesyntax.strategy.OperationProcessor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseProcessorTest {
    private static final OperationProcessor PURCHASE_PROCESSOR = new PurchaseProcessor();
    private static final ProductDao<Product, Integer> DAO = new ProductDaoImpl();
    private static final FruitTransaction.Operation PURCHASE = FruitTransaction.Operation.PURCHASE;
    private static final Product APPLE = Product.APPLE;
    private static final Product BANANA = Product.BANANA;

    @AfterEach
    void tearDown() {
        DAO.clear();
    }

    @DisplayName("Check purchase operation with valid value (Apple)")
    @Order(1)
    @Test
    void operate_checkPurchaseAppleEmptyStorage_ok() {
        DAO.put(APPLE, 15);
        PURCHASE_PROCESSOR.operate(new FruitTransaction(PURCHASE, APPLE, 10));
        assertEquals(DAO.get(APPLE), 5);
        PURCHASE_PROCESSOR.operate(new FruitTransaction(PURCHASE, APPLE, 5));
        assertEquals(DAO.get(APPLE), 0);
    }

    @DisplayName("Check purchase operation with valid value (Apple) and non empty Storage")
    @Order(2)
    @Test
    void operate_checkPurchaseApple_NotOk() {
        assertThrows(RuntimeException.class,
                () -> PURCHASE_PROCESSOR.operate(new FruitTransaction(PURCHASE, APPLE, 20)));
    }

    @DisplayName("Check purchase operation with valid value (Apple) and empty Storage")
    @Order(3)
    @Test
    void operate_checkPurchaseBananaEmptyStorage_ok() {
        DAO.put(BANANA, 147);
        PURCHASE_PROCESSOR.operate(new FruitTransaction(PURCHASE, BANANA, 130));
        assertEquals(DAO.get(BANANA), 17);
        PURCHASE_PROCESSOR.operate(new FruitTransaction(PURCHASE, BANANA, 17));
        assertEquals(DAO.get(BANANA), 0);
    }

    @DisplayName("Check purchase operation with valid value (Apple) and non empty Storage")
    @Order(4)
    @Test
    void operate_checkPurchaseBanana_ok() {
        assertThrows(RuntimeException.class,
                () -> PURCHASE_PROCESSOR.operate(new FruitTransaction(PURCHASE, BANANA, 128)));
    }
}
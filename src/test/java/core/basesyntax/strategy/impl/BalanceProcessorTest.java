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

import static org.junit.jupiter.api.Assertions.assertEquals;

class BalanceProcessorTest {
    private static final OperationProcessor BALANCE_PROCESSOR = new BalanceProcessor();
    private static final ProductDao<Product, Integer> DAO = new ProductDaoImpl();
    private static final FruitTransaction.Operation BALANCE = FruitTransaction.Operation.BALANCE;
    private static final Product APPLE = Product.APPLE;
    private static final Product BANANA = Product.BANANA;

    @AfterEach
    void tearDown() {
        DAO.clear();
    }

    @DisplayName("Check balance operation with valid value (Apple) and empty Storage")
    @Order(1)
    @Test
    void operate_checkBalanceAppleEmptyStorage_ok() {
        BALANCE_PROCESSOR.operate(new FruitTransaction(BALANCE, APPLE, 20));
        assertEquals(DAO.get(APPLE), 20);
    }

    @DisplayName("Check balance operation with valid value (Apple) and non empty Storage")
    @Order(2)
    @Test
    void operate_checkBalanceApple_ok() {
        DAO.put(APPLE, 10);
        BALANCE_PROCESSOR.operate(new FruitTransaction(BALANCE, APPLE, 20));
        assertEquals(DAO.get(APPLE), 30);
    }

    @DisplayName("Check balance operation with valid value (Apple) and empty Storage")
    @Order(3)
    @Test
    void operate_checkBalanceBananaEmptyStorage_ok() {
        BALANCE_PROCESSOR.operate(new FruitTransaction(BALANCE, BANANA, 20));
        assertEquals(DAO.get(BANANA), 20);
    }

    @DisplayName("Check balance operation with valid value (Apple) and non empty Storage")
    @Order(4)
    @Test
    void operate_checkBalanceBanana_ok() {
        DAO.put(BANANA, 10);
        BALANCE_PROCESSOR.operate(new FruitTransaction(BALANCE, BANANA, 20));
        assertEquals(DAO.get(BANANA), 30);
    }
}
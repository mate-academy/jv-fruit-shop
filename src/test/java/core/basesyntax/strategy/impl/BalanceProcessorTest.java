package core.basesyntax.strategy.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.model.Product;
import core.basesyntax.strategy.FruitTransaction;
import core.basesyntax.strategy.OperationProcessor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@DisplayName("BalanceProcessor Test")
class BalanceProcessorTest {
    private static final ProductDao<Product, Integer> DAO = new ProductDaoImpl();
    private static final FruitTransaction.Operation BALANCE = FruitTransaction.Operation.BALANCE;
    private static final Product APPLE = Product.APPLE;
    private static final Product BANANA = Product.BANANA;
    private static OperationProcessor balanceProcessor;

    @BeforeAll
    static void beforeAll() {
        balanceProcessor = new BalanceProcessor(new ProductDaoImpl());
    }

    @AfterEach
    void tearDown() {
        DAO.clear();
    }

    @DisplayName("Check balance operation with valid value (Apple) and empty Storage")
    @Order(1)
    @Test
    void operate_checkBalanceAppleEmptyStorage_ok() {
        balanceProcessor.operate(new FruitTransaction(BALANCE, APPLE, 20));
        assertEquals(DAO.get(APPLE), 20);
    }

    @DisplayName("Check balance operation with valid value (Apple) and non empty Storage")
    @Order(2)
    @Test
    void operate_checkBalanceApple_ok() {
        DAO.put(APPLE, 10);
        balanceProcessor.operate(new FruitTransaction(BALANCE, APPLE, 20));
        assertEquals(DAO.get(APPLE), 30);
    }

    @DisplayName("Check balance operation with valid value (Apple) and empty Storage")
    @Order(3)
    @Test
    void operate_checkBalanceBananaEmptyStorage_ok() {
        balanceProcessor.operate(new FruitTransaction(BALANCE, BANANA, 20));
        assertEquals(DAO.get(BANANA), 20);
    }

    @DisplayName("Check balance operation with valid value (Apple) and non empty Storage")
    @Order(4)
    @Test
    void operate_checkBalanceBanana_ok() {
        DAO.put(BANANA, 10);
        balanceProcessor.operate(new FruitTransaction(BALANCE, BANANA, 20));
        assertEquals(DAO.get(BANANA), 30);
    }

    @DisplayName("Check balance operation with negative value")
    @Order(5)
    @Test
    void operate_checkBalanceNegative_notOk() {
        assertThrows(RuntimeException.class, () -> balanceProcessor.operate(
                new FruitTransaction(BALANCE, BANANA, -20)));
    }
}

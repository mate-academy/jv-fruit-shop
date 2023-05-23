package core.basesyntax.strategy.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.model.Product;
import core.basesyntax.strategy.FruitTransaction;
import core.basesyntax.strategy.OperationProcessor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@DisplayName("SupplyProcessor Test")
class SupplyProcessorTest {

    private static final OperationProcessor SUPPLY_PROCESSOR = new SupplyProcessor();
    private static final ProductDao<Product, Integer> DAO = new ProductDaoImpl();
    private static final FruitTransaction.Operation SUPPLY = FruitTransaction.Operation.SUPPLY;
    private static final Product APPLE = Product.APPLE;
    private static final Product BANANA = Product.BANANA;

    @AfterEach
    void tearDown() {
        DAO.clear();
    }

    @DisplayName("Check supply operation with valid value (Apple) and empty Storage")
    @Order(1)
    @Test
    void operate_checkSupplyAppleEmptyStorage_ok() {
        SUPPLY_PROCESSOR.operate(new FruitTransaction(SUPPLY, APPLE, 20));
        assertEquals(DAO.get(APPLE), 20);
    }

    @DisplayName("Check supply operation with valid value (Apple) and non empty Storage")
    @Order(2)
    @Test
    void operate_checkSupplyApple_ok() {
        DAO.put(APPLE, 10);
        SUPPLY_PROCESSOR.operate(new FruitTransaction(SUPPLY, APPLE, 20));
        assertEquals(DAO.get(APPLE), 30);
    }

    @DisplayName("Check supply operation with valid value (Apple) and empty Storage")
    @Order(3)
    @Test
    void operate_checkSupplyBananaEmptyStorage_ok() {
        SUPPLY_PROCESSOR.operate(new FruitTransaction(SUPPLY, BANANA, 20));
        assertEquals(DAO.get(BANANA), 20);
    }

    @DisplayName("Check supply operation with valid value (Apple) and non empty Storage")
    @Order(4)
    @Test
    void operate_checkSupplyBanana_ok() {
        DAO.put(BANANA, 10);
        SUPPLY_PROCESSOR.operate(new FruitTransaction(SUPPLY, BANANA, 20));
        assertEquals(DAO.get(BANANA), 30);
    }
}

package core.basesyntax.strategy.impl;

import static core.basesyntax.model.Product.APPLE;
import static core.basesyntax.model.Product.BANANA;
import static core.basesyntax.strategy.FruitTransaction.Operation.SUPPLY;
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

@DisplayName("SupplyProcessor Test")
class SupplyProcessorTest {
    private final ProductDao<Product, Integer> dao = new ProductDaoImpl();
    private final OperationProcessor supplyProcessor = new SupplyProcessor(new ProductDaoImpl());

    @AfterEach
    void tearDown() {
        dao.clear();
    }

    @DisplayName("Check supply operation with valid value (Apple) and empty Storage")
    @Order(1)
    @Test
    void operate_checkSupplyAppleEmptyStorage_ok() {
        supplyProcessor.operate(new FruitTransaction(SUPPLY, APPLE, 20));
        assertEquals(dao.get(APPLE), 20);
    }

    @DisplayName("Check supply operation with valid value (Apple) and non empty Storage")
    @Order(2)
    @Test
    void operate_checkSupplyApple_ok() {
        dao.put(APPLE, 10);
        supplyProcessor.operate(new FruitTransaction(SUPPLY, APPLE, 20));
        assertEquals(dao.get(APPLE), 30);
    }

    @DisplayName("Check supply operation with valid value (Apple) and empty Storage")
    @Order(3)
    @Test
    void operate_checkSupplyBananaEmptyStorage_ok() {
        supplyProcessor.operate(new FruitTransaction(SUPPLY, BANANA, 20));
        assertEquals(dao.get(BANANA), 20);
    }

    @DisplayName("Check supply operation with valid value (Apple) and non empty Storage")
    @Order(4)
    @Test
    void operate_checkSupplyBanana_ok() {
        dao.put(BANANA, 10);
        supplyProcessor.operate(new FruitTransaction(SUPPLY, BANANA, 20));
        assertEquals(dao.get(BANANA), 30);
    }

    @DisplayName("Check supply operation with negative value")
    @Order(5)
    @Test
    void operate_checkSupplyNegative_notOk() {
        assertThrows(InvalidTransaction.class, () -> supplyProcessor.operate(
                new FruitTransaction(SUPPLY, BANANA, -20)));
    }
}

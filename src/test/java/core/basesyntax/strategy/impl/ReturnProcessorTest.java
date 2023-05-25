package core.basesyntax.strategy.impl;

import static core.basesyntax.model.Product.APPLE;
import static core.basesyntax.model.Product.BANANA;
import static core.basesyntax.strategy.FruitTransaction.Operation.RETURN;
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

@DisplayName("ReturnProcessor Test")
class ReturnProcessorTest {
    private final ProductDao<Product, Integer> dao = new ProductDaoImpl();
    private final OperationProcessor returnProcessor = new ReturnProcessor(new ProductDaoImpl());

    @AfterEach
    void tearDown() {
        dao.clear();
    }

    @DisplayName("Check return operation with valid value (Apple) and empty Storage")
    @Order(1)
    @Test
    void operate_checkReturnAppleEmptyStorage_ok() {
        returnProcessor.operate(new FruitTransaction(RETURN, APPLE, 20));
        assertEquals(dao.get(APPLE), 20);
    }

    @DisplayName("Check return operation with valid value (Apple) and non empty Storage")
    @Order(2)
    @Test
    void operate_checkReturnApple_ok() {
        dao.put(APPLE, 10);
        returnProcessor.operate(new FruitTransaction(RETURN, APPLE, 20));
        assertEquals(dao.get(APPLE), 30);
    }

    @DisplayName("Check return operation with valid value (Apple) and empty Storage")
    @Order(3)
    @Test
    void operate_checkReturnBananaEmptyStorage_ok() {
        returnProcessor.operate(new FruitTransaction(RETURN, BANANA, 20));
        assertEquals(dao.get(BANANA), 20);
    }

    @DisplayName("Check return operation with valid value (Apple) and non empty Storage")
    @Order(4)
    @Test
    void operate_checkReturnBanana_ok() {
        dao.put(BANANA, 10);
        returnProcessor.operate(new FruitTransaction(RETURN, BANANA, 20));
        assertEquals(dao.get(BANANA), 30);
    }

    @DisplayName("Check return operation with negative value")
    @Order(5)
    @Test
    void operate_checkReturnNegative_notOk() {
        assertThrows(InvalidTransaction.class, () -> returnProcessor.operate(
                new FruitTransaction(RETURN, BANANA, -20)));
    }
}

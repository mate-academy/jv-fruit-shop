package core.basesyntax.strategy.impl;

import static core.basesyntax.strategy.FruitTransaction.Operation.BALANCE;
import static core.basesyntax.strategy.FruitTransaction.Operation.PURCHASE;
import static core.basesyntax.strategy.FruitTransaction.Operation.RETURN;
import static core.basesyntax.strategy.FruitTransaction.Operation.SUPPLY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.strategy.OperationProcessor;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@DisplayName("OperationStrategyImpl Test")
class OperationStrategyImplTest {
    private static OperationStrategy strategy;

    @BeforeAll
    static void beforeAll() {
        strategy = new OperationStrategyImpl(Map.of(
                BALANCE, new BalanceProcessor(new ProductDaoImpl()),
                SUPPLY, new SupplyProcessor(new ProductDaoImpl()),
                PURCHASE, new PurchaseProcessor(new ProductDaoImpl()),
                RETURN, new ReturnProcessor(new ProductDaoImpl())));
    }

    @DisplayName("Check method get in Operation Strategy with Balance Processor")
    @Order(1)
    @Test
    void get_getBalanceOperationStrategy_ok() {

        Class<? extends OperationProcessor> actualOperationClass =
                strategy.get(BALANCE).getClass();
        Class<? extends OperationProcessor> expectedClass = BalanceProcessor.class;
        assertEquals(expectedClass, actualOperationClass);
    }

    @DisplayName("Check method get in Operation Strategy with Purchase Processor")
    @Order(2)
    @Test
    void get_getPurchaseOperationStrategy_ok() {
        Class<? extends OperationProcessor> actualOperationClass =
                strategy.get(PURCHASE).getClass();
        Class<? extends OperationProcessor> expectedClass = PurchaseProcessor.class;
        assertEquals(expectedClass, actualOperationClass);
    }

    @DisplayName("Check method get in Operation Strategy with Return Processor")
    @Order(3)
    @Test
    void get_getReturnOperationStrategy_ok() {
        Class<? extends OperationProcessor> actualOperationClass =
                strategy.get(RETURN).getClass();
        Class<? extends OperationProcessor> expectedClass = ReturnProcessor.class;
        assertEquals(expectedClass, actualOperationClass);
    }

    @DisplayName("Check method get in Operation Strategy with Supply Processor")
    @Order(4)
    @Test
    void get_getSupplyOperationStrategy_ok() {
        Class<? extends OperationProcessor> actualOperationClass =
                strategy.get(SUPPLY).getClass();
        Class<? extends OperationProcessor> expectedClass = SupplyProcessor.class;
        assertEquals(expectedClass, actualOperationClass);
    }

    @DisplayName("Check method get in Operation Strategy with invalid data - null")
    @Order(5)
    @Test
    void get_getNullOperationStrategy_notOk() {
        assertThrows(RuntimeException.class, () -> strategy.get(null));
    }
}

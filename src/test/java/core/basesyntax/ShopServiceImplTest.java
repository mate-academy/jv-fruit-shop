package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.BalanceOperation;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.OperationStrategy;
import core.basesyntax.operation.OperationStrategyImpl;
import core.basesyntax.operation.PurchaseOperation;
import core.basesyntax.operation.ReturnOperation;
import core.basesyntax.operation.SupplyOperation;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShopServiceImplTest {
    private ShopService shopService;
    private Map<FruitTransaction.Operation, OperationHandler> handlers;

    @BeforeEach
    void setUp() {
        handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());

        OperationStrategy strategy = new OperationStrategyImpl(handlers);
        shopService = new ShopServiceImpl(strategy);
    }

    @Test
    void processComplexTransaction() {
        List<FruitTransaction> transactions = Arrays.asList(
                new FruitTransaction(FruitTransaction.Operation.BALANCE, "banana", 100),
                new FruitTransaction(FruitTransaction.Operation.SUPPLY, "apple", 50),
                new FruitTransaction(FruitTransaction.Operation.PURCHASE, "banana", 30),
                new FruitTransaction(FruitTransaction.Operation.RETURN, "banana", 10)
        );

        Map<String, Integer> result = shopService.process(transactions);
        assertEquals(80, result.get("banana").intValue());
        assertEquals(50, result.get("apple").intValue());
    }

    @Test
    void processInvalidTransaction() {
        List<FruitTransaction> transactions = Arrays.asList(
                new FruitTransaction(FruitTransaction.Operation.BALANCE, "banana", 20),
                new FruitTransaction(FruitTransaction.Operation.PURCHASE, "banana", 30)
        );

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> shopService.process(transactions));

        assertTrue(exception.getMessage().contains("banana"));
    }
}

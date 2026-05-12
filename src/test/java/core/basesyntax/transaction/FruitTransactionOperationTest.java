package core.basesyntax.transaction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.db.ShopStorage;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handler.BalanceOperationHandler;
import core.basesyntax.strategy.handler.Operation;
import core.basesyntax.strategy.handler.OperationHandler;
import core.basesyntax.strategy.handler.PurchaseOperationHandler;
import core.basesyntax.strategy.handler.ReturnOperationHandler;
import core.basesyntax.strategy.handler.SupplyOperationHandler;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FruitTransactionOperationTest {

    private ShopTransaction transaction;
    private ShopService shopService;

    @BeforeEach
    void setUp() {
        transaction = new ShopTransaction(new ShopStorage());
        Map<Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(Operation.BALANCE, new BalanceOperationHandler());
        handlers.put(Operation.SUPPLY, new SupplyOperationHandler());
        handlers.put(Operation.PURCHASE, new PurchaseOperationHandler());
        handlers.put(Operation.RETURN, new ReturnOperationHandler());
        OperationStrategy strategy = new OperationStrategyImpl(handlers);
        shopService = new ShopServiceImpl(strategy, transaction);
    }

    @ParameterizedTest
    @CsvSource({
            "b, BALANCE",
            "s, SUPPLY",
            "p, PURCHASE",
            "r, RETURN",
            "B, BALANCE",
            " S , SUPPLY"
    })
    void fromCode_ShouldReturnCorrectOperation(String code, Operation expected) {
        assertEquals(expected, Operation.fromCode(code));
    }

    @Test
    void fromCode_ShouldThrow_WhenUnknownCode() {
        assertThrows(IllegalArgumentException.class,
                () -> Operation.fromCode("x"));
    }

    @Test
    void fromCode_ShouldThrow_WhenCodeIsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> Operation.fromCode(null));
    }

    @Test
    void constructor_ShouldInitializeFields() {
        FruitTransaction tx = new FruitTransaction("b", "apple", 10);
        assertEquals("apple", tx.getFruit());
        assertEquals(10, tx.getQuantity());
    }

    private String uniqueKey() {
        return "fruit_" + System.nanoTime();
    }

    @Test
    void execute_Balance_ShouldInitializeStorage() {
        String key = uniqueKey();
        FruitTransaction ft = new FruitTransaction("b", key, 20);
        shopService.process(Collections.singletonList(ft));
        assertEquals(20, transaction.get(key));
    }

    @Test
    void execute_Supply_ShouldIncreaseQuantity() {
        String key = uniqueKey();
        FruitTransaction b = new FruitTransaction("b", key, 10);
        FruitTransaction s = new FruitTransaction("s", key, 5);
        shopService.process(java.util.List.of(b, s));
        assertEquals(15, transaction.get(key));
    }

    @Test
    void execute_Purchase_ShouldDecreaseQuantity() {
        String key = uniqueKey();
        FruitTransaction b = new FruitTransaction("b", key, 10);
        FruitTransaction p = new FruitTransaction("p", key, 4);
        shopService.process(java.util.List.of(b, p));
        assertEquals(6, transaction.get(key));
    }

    @Test
    void execute_Purchase_ShouldThrow_WhenInsufficientBalance() {
        String key = uniqueKey();
        FruitTransaction b = new FruitTransaction("b", key, 5);
        FruitTransaction p = new FruitTransaction("p", key, 10);
        shopService.process(Collections.singletonList(b));
        assertThrows(IllegalStateException.class, () -> {
            shopService.process(Collections.singletonList(p));
        });
    }
}

package core.basesyntax.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.FruitTransaction;
import core.basesyntax.operations.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ShopServiceImplTest {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers =
            new HashMap<>();
    private final OperationStrategy operationStrategy =
            new OperationStrategyImpl(operationHandlers);
    private final ShopService shopService = new ShopServiceImpl(operationStrategy);
    private final FruitTransaction fruitTransaction = new FruitTransaction(null, null, 0);

    @Test
    void emptyList_NotOk() {
        assertThrows(RuntimeException.class, () -> {
            shopService.process(Collections.emptyList());
        });
    }

    @Test
    void fruitIsNull_NotOk() {
        assertThrows(RuntimeException.class, () -> {
            shopService.process(List.of(fruitTransaction));
        });
    }
}

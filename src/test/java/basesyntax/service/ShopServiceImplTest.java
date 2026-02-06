package basesyntax.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import basesyntax.model.FruitTransaction;
import basesyntax.service.impl.ShopServiceImpl;
import basesyntax.strategy.BalanceOperation;
import basesyntax.strategy.OperationStrategy;
import basesyntax.strategy.OperationStrategyImpl;
import basesyntax.strategy.PurchaseOperation;
import basesyntax.strategy.ReturnOperation;
import basesyntax.strategy.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ShopServiceImplTest {

    @Test
    void process_validData_ok() {
        Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());

        OperationStrategy strategy = new OperationStrategyImpl(handlers);
        ShopService shopService = new ShopServiceImpl(strategy);

        List<FruitTransaction> transactions = List.of(
                new FruitTransaction(FruitTransaction.Operation.SUPPLY, "banana", 10),
                new FruitTransaction(FruitTransaction.Operation.PURCHASE, "banana", 3)
        );

        Map<String, Integer> result = shopService.process(transactions);

        assertEquals(7, result.get("banana"));
    }
}

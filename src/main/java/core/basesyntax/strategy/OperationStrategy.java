package core.basesyntax.strategy;

import core.basesyntax.db.StorageImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.BalanceService;
import core.basesyntax.operation.PurchaseService;
import core.basesyntax.operation.ReturnService;
import core.basesyntax.operation.SupplyService;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationService> strategyMap;

    public OperationStrategy(StorageImpl storage) {
        this.strategyMap = createStrategyMap(storage);
    }

    private Map<FruitTransaction.Operation, OperationService>
                                    createStrategyMap(StorageImpl storage) {
        Map<FruitTransaction.Operation, OperationService> map = new HashMap<>();
        map.put(FruitTransaction.Operation.BALANCE, new BalanceService(storage));
        map.put(FruitTransaction.Operation.SUPPLY, new SupplyService(storage));
        map.put(FruitTransaction.Operation.RETURN, new ReturnService(storage));
        map.put(FruitTransaction.Operation.PURCHASE, new PurchaseService(storage));
        return map;
    }

    public OperationService get(FruitTransaction fruitTransaction) {
        return strategyMap.get(fruitTransaction.getOperation());
    }
}

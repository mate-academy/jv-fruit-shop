package core.basesyntax.strategy;

import core.basesyntax.db.StorageImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.Balance;
import core.basesyntax.operation.Purchase;
import core.basesyntax.operation.Return;
import core.basesyntax.operation.Supply;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationService> strategyMap;

    public OperationStrategy(StorageImpl storage) {
        this.strategyMap = createStrategyMap(storage);
    }

    private Map<FruitTransaction.Operation, OperationService> createStrategyMap(StorageImpl data) {
        Map<FruitTransaction.Operation, OperationService> map = new HashMap<>();
        map.put(FruitTransaction.Operation.BALANCE, new Balance(data));
        map.put(FruitTransaction.Operation.SUPPLY, new Supply(data));
        map.put(FruitTransaction.Operation.RETURN, new Return(data));
        map.put(FruitTransaction.Operation.PURCHASE, new Purchase(data));
        return map;
    }

    public OperationService get(FruitTransaction fruitTransaction) {
        return strategyMap.get(fruitTransaction.getOperation());
    }
}



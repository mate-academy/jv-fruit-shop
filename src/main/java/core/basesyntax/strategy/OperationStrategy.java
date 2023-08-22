package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> map;

    public OperationStrategy(OperationHandler... strategies) {
        this.map = new HashMap<>();
        for (OperationHandler strategy : strategies) {
            map.put(strategy.getType(), strategy);
        }
    }

    public OperationHandler getStrategy(FruitTransaction.Operation operation) {
        return map.get(operation);
    }
}

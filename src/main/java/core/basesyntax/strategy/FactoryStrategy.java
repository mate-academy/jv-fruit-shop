package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class FactoryStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> strategyType;

    public FactoryStrategy() {
        strategyType = new HashMap<>();
        strategyType.put(FruitTransaction.Operation.BALANCE, new Balance());
        strategyType.put(FruitTransaction.Operation.PURCHASE, new Purchase());
        strategyType.put(FruitTransaction.Operation.SUPPLY, new Supply());
        strategyType.put(FruitTransaction.Operation.RETURN, new Return());
    }

    public OperationHandler getFruitService(FruitTransaction.Operation operation) {
        return strategyType.get(operation);
    }
}

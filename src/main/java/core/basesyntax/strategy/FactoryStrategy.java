package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class FactoryStrategy {
    private final Map<FruitTransaction.Operation, OperationService> strategies;

    public FactoryStrategy() {
        strategies = new HashMap<>();
        OperationService plusOperationService = new PlusOperationService();
        strategies.put(FruitTransaction.Operation.BALANCE, plusOperationService);
        strategies.put(FruitTransaction.Operation.SUPPLY, plusOperationService);
        strategies.put(FruitTransaction.Operation.RETURN, plusOperationService);
        strategies.put(FruitTransaction.Operation.PURCHASE, new MinusOperationService());
    }

    public OperationService getOperationService(FruitTransaction.Operation operation) {
        return strategies.get(operation);
    }
}

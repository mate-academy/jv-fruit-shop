package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> fruitTransactionMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> fruitTransactionMap) {
        this.fruitTransactionMap = fruitTransactionMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return fruitTransactionMap.get(operation);
    }
}

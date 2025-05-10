package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, TransactionProcessor> codeServiceMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            TransactionProcessor> codeServiceMap) {
        this.codeServiceMap = codeServiceMap;
    }

    public TransactionProcessor getTransactionProcessor(FruitTransaction.Operation operation) {
        return codeServiceMap.get(operation);
    }
}

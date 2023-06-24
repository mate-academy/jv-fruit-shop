package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.TransactionHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, TransactionHandler> transactionRecordMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            TransactionHandler> transactionRecordMap) {
        this.transactionRecordMap = transactionRecordMap;
    }

    @Override
    public TransactionHandler get(FruitTransaction.Operation operation) {
        return transactionRecordMap.get(operation);
    }
}

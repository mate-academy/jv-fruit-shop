package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.Operation;
import java.util.HashMap;

public class OperationStrategyImpl implements OperationStrategy {
    private HashMap<FruitTransaction.Operation, Operation> operationStrategyHashMap;

    public OperationStrategyImpl(HashMap<FruitTransaction.Operation, Operation>
                                         operationOperationStrategyHashMap) {
        this.operationStrategyHashMap = operationOperationStrategyHashMap;
    }

    @Override
    public Operation getOperation(FruitTransaction transaction) {
        return operationStrategyHashMap.get(transaction.getOperation());
    }
}

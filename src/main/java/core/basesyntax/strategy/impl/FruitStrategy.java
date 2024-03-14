package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class FruitStrategy {
    private final Map<Operation, OperationHandler> operationMap;

    public FruitStrategy(Map<Operation, OperationHandler> operationMap) {
        this.operationMap = operationMap;
    }

    public void executeOperationServiceByOperation(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            if (transaction.operation() == null) {
                throw new RuntimeException("No such strategy");
            }
            OperationHandler operationHandler = operationMap.get(transaction.operation());
            operationHandler.execute(transaction.fruit(), transaction.quantity());
        }
    }
}

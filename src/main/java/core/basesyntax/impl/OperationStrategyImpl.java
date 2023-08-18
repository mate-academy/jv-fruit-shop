package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {

    @Override
    public void getOperationAndProcess(List<FruitTransaction> transactions,
                                                   Map<FruitTransaction.Operation,
                                                           OperationHandler> operationHashMap) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler operation = operationHashMap.get(transaction);
            operation.processWithTransaction(transaction);
        }
    }
}

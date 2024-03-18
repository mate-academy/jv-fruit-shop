package core.basesyntax.service.strategy;

import core.basesyntax.model.OperationType;
import core.basesyntax.model.impl.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy<FruitTransaction> {
    private final Map<OperationType, OperationHandler<FruitTransaction>> operationHandlerMap;

    public OperationStrategyImpl(Map<OperationType,
            OperationHandler<FruitTransaction>> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler<FruitTransaction> get(FruitTransaction transaction) {
        return operationHandlerMap.get(transaction.getTransactionType());
    }
}

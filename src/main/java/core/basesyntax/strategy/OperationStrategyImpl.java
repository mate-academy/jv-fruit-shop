package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler>
                                         operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public void proceedOperation(FruitTransaction fruitTransaction) {
        operationHandlerMap.get(fruitTransaction.getOperation()).handle(fruitTransaction);
    }
}

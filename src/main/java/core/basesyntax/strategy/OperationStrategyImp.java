package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.handler.OperationHandler;
import java.util.List;
import java.util.Map;

public class OperationStrategyImp implements OperationStrategy {
    private Map<Operation, OperationHandler> operationOperationHandlerMap;

    public OperationStrategyImp(Map<Operation,
            OperationHandler> operationOperationHandlerMap) {
        this.operationOperationHandlerMap = operationOperationHandlerMap;
    }

    @Override
    public boolean getHandle(List<FruitTransaction> fruitTransaction) {
        for (FruitTransaction fruit : fruitTransaction) {
            operationOperationHandlerMap.get(fruit.getOperation()).handle(fruit);
        }
        return true;
    }
}

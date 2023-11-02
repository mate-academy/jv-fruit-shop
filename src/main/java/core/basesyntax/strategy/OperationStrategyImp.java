package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.OperationHandler;
import java.util.List;
import java.util.Map;

public class OperationStrategyImp implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationOperationHandlerMap;

    public OperationStrategyImp(Map<FruitTransaction.Operation,
            OperationHandler> operationOperationHandlerMap) {
        this.operationOperationHandlerMap = operationOperationHandlerMap;
    }

    @Override
    public boolean getOperations(List<FruitTransaction> fruitTransaction) {
        for (FruitTransaction fruit : fruitTransaction) {
            operationOperationHandlerMap.get(fruit.getOperation()).doOperation(fruit);
        }
        return true;
    }
}

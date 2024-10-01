package fruitshop.strategy;

import fruitshop.model.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler>
                                         operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public void getOperation(FruitTransaction fruitTransaction) {
        OperationHandler operationHandler = operationHandlers.get(fruitTransaction.getOperation());
        operationHandler.handler(fruitTransaction);
    }
}

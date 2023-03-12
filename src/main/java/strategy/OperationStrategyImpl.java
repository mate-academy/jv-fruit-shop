package strategy;

import fruittransaction.FruitTransaction;
import java.util.Map;
import transactionexecutor.OperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> handlersMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> handlersMap) {
        this.handlersMap = handlersMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return handlersMap.get(operation);
    }
}

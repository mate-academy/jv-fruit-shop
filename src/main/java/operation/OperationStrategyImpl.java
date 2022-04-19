package operation;

import java.util.Map;
import model.FruitTransaction;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation,OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(String operation) {
        return operationHandlerMap.entrySet()
                .stream()
                .filter(op -> op.getKey().getSymbolOperation().equals(operation))
                .map(Map.Entry::getValue)
                .findFirst().get();
    }
}

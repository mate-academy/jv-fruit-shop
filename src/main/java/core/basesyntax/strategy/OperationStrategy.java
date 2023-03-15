package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationStrategy {
    private static Map<FruitTransaction.Operation, OperationHandler> operationHanlderMap;

    public OperationStrategy(Map<FruitTransaction.Operation, OperationHandler>
                                     operationHanlderMap) {
        this.operationHanlderMap = operationHanlderMap;
    }

    public OperationHandler get(FruitTransaction.Operation type) {
        return operationHanlderMap.get(type);
    }
}

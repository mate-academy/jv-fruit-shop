package strategy;

import java.util.Map;
import model.FruitTransaction;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHalndlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHalndlerMap) {
        this.operationHalndlerMap = operationHalndlerMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation codeOperation) {
        return operationHalndlerMap.get(codeOperation);
    }
}

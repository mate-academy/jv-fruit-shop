package strategy;

import java.util.Map;
import model.FruitTransaction;
import service.OperationHandler;
import service.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> mapServiceOperation;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> mapServiceOperation) {
        this.mapServiceOperation = mapServiceOperation;
    }

    @Override
    public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
        return mapServiceOperation.get(operation);
    }
}

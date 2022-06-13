package strategy;

import java.util.Map;
import model.FruitTransaction;
import service.OperationHandler;
import service.OperationStrategy;

public class OperationStrategyImplementation implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> mapServiceOperation;

    public OperationStrategyImplementation(Map<FruitTransaction.Operation,
            OperationHandler> mapServiceOperation) {
        this.mapServiceOperation = mapServiceOperation;
    }

    @Override
    public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
        return mapServiceOperation.get(operation);
    }
}

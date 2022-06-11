package strategy;

import java.util.Map;
import model.FruitTransaction;
import service.OperationService;
import service.OperationStrategy;

public class OperationHandler implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationService> mapServiceOperation;

    public OperationHandler(Map<FruitTransaction.Operation, OperationService> mapServiceOperation) {
        this.mapServiceOperation = mapServiceOperation;
    }

    @Override
    public OperationService getOperationServiceByTransaction(FruitTransaction transaction) {
        return mapServiceOperation.get(transaction.getOperation());
    }
}

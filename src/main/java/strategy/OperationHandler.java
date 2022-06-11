package strategy;

import model.FruitTransaction;
import service.OperationService;
import service.OperationStrategy;
import service.impl.StorageImplementation;

public class OperationHandler implements OperationStrategy {
    private final StorageImplementation storageImplementation;

    public OperationHandler(StorageImplementation storageImplementation) {
        this.storageImplementation = storageImplementation;
    }

    @Override
    public OperationService getOperationServiceByTransaction(FruitTransaction transaction) {
        switch (transaction.getOperation()) {
            case SUPPLY:
            case RETURN:
                return new AddOperationImplementation(storageImplementation);
            case PURCHASE:
                return new SubtractOperationImplementation(storageImplementation);
            default:
                return new SetBalanceOperationImplementation(storageImplementation);
        }
    }
}

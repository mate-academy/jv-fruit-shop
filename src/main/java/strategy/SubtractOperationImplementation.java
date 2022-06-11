package strategy;

import model.FruitTransaction;
import service.OperationService;
import service.impl.StorageImplementation;

public class SubtractOperationImplementation implements OperationService {
    private final StorageImplementation storageImplementation;

    SubtractOperationImplementation(StorageImplementation storageImplementation) {
        this.storageImplementation = storageImplementation;
    }

    @Override
    public void doTransaction(FruitTransaction transaction) {
        storageImplementation.subtract(transaction.getFruit(), transaction.getQuantity());
    }
}

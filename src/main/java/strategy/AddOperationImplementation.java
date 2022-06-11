package strategy;

import model.FruitTransaction;
import service.OperationService;
import service.impl.StorageImplementation;

public class AddOperationImplementation implements OperationService {
    private final StorageImplementation accountStorageImplementation;

    AddOperationImplementation(StorageImplementation accountStorageImplementation) {
        this.accountStorageImplementation = accountStorageImplementation;
    }

    @Override
    public void doTransaction(FruitTransaction transaction) {
        accountStorageImplementation.add(transaction.getFruit(), transaction.getQuantity());
    }
}

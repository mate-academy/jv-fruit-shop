package strategy;

import model.FruitTransaction;
import service.OperationService;
import service.impl.StorageImplementation;

public class SetBalanceOperationImplementation implements OperationService {
    private final StorageImplementation storageImplementation;

    SetBalanceOperationImplementation(StorageImplementation storageImplementation) {
        this.storageImplementation = storageImplementation;
    }

    @Override
    public void doTransaction(FruitTransaction transaction) {
        storageImplementation.set(transaction.getFruit(), transaction.getQuantity());
    }
}

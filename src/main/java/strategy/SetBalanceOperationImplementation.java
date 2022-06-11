package strategy;

import model.FruitTransaction;
import service.OperationService;
import service.StorageService;

public class SetBalanceOperationImplementation implements OperationService {
    private final StorageService storageService;

    public SetBalanceOperationImplementation(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void doTransaction(FruitTransaction transaction) {
        storageService.set(transaction.getFruit(), transaction.getQuantity());
    }
}

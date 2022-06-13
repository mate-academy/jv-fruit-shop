package strategy;

import model.FruitTransaction;
import service.OperationHandler;
import service.StorageService;

public class SetBalanceOperationHandler implements OperationHandler {
    private final StorageService storageService;

    public SetBalanceOperationHandler(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void doTransaction(FruitTransaction transaction) {
        storageService.set(transaction.getFruit(), transaction.getQuantity());
    }
}

package strategy;

import model.FruitTransaction;
import service.OperationHandler;
import service.StorageService;

public class SubtractOperationHandler implements OperationHandler {
    private final StorageService storageService;

    public SubtractOperationHandler(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void doTransaction(FruitTransaction transaction) {
        storageService.subtract(transaction.getFruit(), transaction.getQuantity());
    }
}

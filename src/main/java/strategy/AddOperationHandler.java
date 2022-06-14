package strategy;

import model.FruitTransaction;
import service.OperationHandler;
import service.StorageService;

public class AddOperationHandler implements OperationHandler {
    private final StorageService storageService;

    public AddOperationHandler(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void doTransaction(FruitTransaction transaction) {
        storageService.add(transaction.getFruit(), transaction.getQuantity());
    }
}

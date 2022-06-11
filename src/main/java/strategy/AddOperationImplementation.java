package strategy;

import model.FruitTransaction;
import service.OperationService;
import service.StorageService;

public class AddOperationImplementation implements OperationService {
    private final StorageService storageService;

    public AddOperationImplementation(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void doTransaction(FruitTransaction transaction) {
        storageService.add(transaction.getFruit(), transaction.getQuantity());
    }
}

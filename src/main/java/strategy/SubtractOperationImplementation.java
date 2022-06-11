package strategy;

import model.FruitTransaction;
import service.OperationService;
import service.StorageService;

public class SubtractOperationImplementation implements OperationService {
    private final StorageService storageService;

    public SubtractOperationImplementation(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void doTransaction(FruitTransaction transaction) {
        storageService.subtract(transaction.getFruit(), transaction.getQuantity());
    }
}

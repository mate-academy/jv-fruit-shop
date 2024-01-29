package strategy.operation;

import service.StorageService;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void execute(String fruit, int quantity, StorageService storageService) {
        storageService.addFruit(fruit, quantity);
    }
}

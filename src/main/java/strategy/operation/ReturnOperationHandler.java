package strategy.operation;

import service.StorageService;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void execute(String fruit, int quantity, StorageService storageService) {
        storageService.addFruit(fruit, quantity);
    }
}

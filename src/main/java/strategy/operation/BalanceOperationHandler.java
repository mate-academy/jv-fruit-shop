package strategy.operation;

import service.StorageService;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void execute(String fruit, int quantity, StorageService storageService) {
        storageService.addFruit(fruit, quantity);
    }
}

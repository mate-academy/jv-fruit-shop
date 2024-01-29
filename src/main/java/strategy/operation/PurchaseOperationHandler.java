package strategy.operation;

import service.StorageService;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void execute(String fruit, int quantity, StorageService storageService) {
        int currentQuantity = storageService.getFruitQuantity(fruit);
        if (currentQuantity < quantity) {
            throw new RuntimeException("Not enough " + fruit + " in stock to make purchase.");
        }
        storageService.addFruit(fruit, -quantity);
    }
}

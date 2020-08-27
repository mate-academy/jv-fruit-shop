package operations;

import interfaces.OperationStrategy;
import model.Fruit;
import services.StorageService;

public class BuyOperation implements OperationStrategy {
    StorageService storageService = new StorageService();

    @Override
    public void operate(Fruit fruit) {
        storageService.buy(fruit.getName(), fruit.getQuantity());
    }
}

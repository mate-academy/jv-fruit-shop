package operations;

import interfaces.OperationStrategy;
import model.Fruit;
import services.StorageService;

public class SupplyOperations implements OperationStrategy {
    StorageService storageService = new StorageService();

    @Override
    public void operate(Fruit fruit) {
        storageService.put(fruit);
    }
}

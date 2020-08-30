package operations;

import interfaces.IOperationStrategy;
import model.Position;
import services.StorageService;

public class BuyOperation implements IOperationStrategy {
    StorageService storageService = new StorageService();

    @Override
    public void operate(Position position) {
        storageService.buy(position.getName(), position.getQuantity());
    }
}

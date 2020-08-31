package operations;

import interfaces.OperationStrategy;
import model.Position;
import services.StorageServiceImpl;

public class BuyOperation implements OperationStrategy {
    private StorageServiceImpl storageServiceImpl = new StorageServiceImpl();

    @Override
    public void operate(Position position) {
        storageServiceImpl.buy(position.getName(), position.getQuantity());
    }
}

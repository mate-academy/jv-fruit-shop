package operations;

import interfaces.OperationStrategy;
import model.Position;
import services.StorageServiceImpl;

public class SupplyOperation implements OperationStrategy {
    StorageServiceImpl storageServiceImpl = new StorageServiceImpl();

    @Override
    public void operate(Position position) {
        storageServiceImpl.put(position);
    }
}

package operations;

import static service.impl.StorageDao.storage;

import interfaces.OperationHandler;
import service.impl.FruitTransaction;

public class SupplyOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction tx) {
        if (tx != null) {
            if (tx.getQuantity() < 0) {
                throw new IllegalArgumentException("Quantity cannot be negative: "
                        + tx.getQuantity());
            }
            storage.put(tx.getFruit(),
                    storage.getOrDefault(tx.getFruit(), 0)
                            + tx.getQuantity());
        } else {
            throw new IllegalArgumentException("Transaction cannot be null");
        }
    }
}

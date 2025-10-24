package operations;

import static service.impl.StorageDao.storage;

import interfaces.OperationHandler;
import service.impl.FruitTransaction;

public class BalanceOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction tx) {
        if (tx == null) {
            throw new IllegalArgumentException("Transaction cannot be null");
        }
        if (tx.getQuantity() < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative: " + tx.getQuantity());
        }
        storage.put(tx.getFruit(), tx.getQuantity());
    }
}

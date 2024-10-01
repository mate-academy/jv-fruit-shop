package fruitshop.strategy;

import fruitshop.db.Storage;
import fruitshop.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handler(FruitTransaction fruitTransaction) {
        Storage storage = new Storage();
        if (fruitTransaction.getQuantity() >= 0) {
            storage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        } else {
            throw new RuntimeException("negative balance cannot be recorded");
        }
    }
}

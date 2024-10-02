package fruitshop.strategy;

import fruitshop.db.Storage;
import fruitshop.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    private final Storage storage = new Storage();

    @Override
    public void handler(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() >= 0) {
            storage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        } else {
            throw new RuntimeException("negative balance cannot be recorded at "
                    + BalanceOperation.class);
        }
    }
}

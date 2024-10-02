package fruitshop.strategy;

import fruitshop.db.Storage;
import fruitshop.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    private final Storage storage = new Storage();

    @Override
    public void handler(FruitTransaction fruitTransaction) {
        int newQuantity = storage.getQuantity(fruitTransaction.getFruit())
                - fruitTransaction.getQuantity();
        if (newQuantity >= 0) {
            storage.put(fruitTransaction.getFruit(), newQuantity);
        } else {
            throw new RuntimeException("negative balance cannot be recorded at "
                    + PurchaseOperation.class);
        }
    }
}

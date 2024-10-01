package fruitshop.strategy;

import fruitshop.db.Storage;
import fruitshop.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handler(FruitTransaction fruitTransaction) {
        Storage storage = new Storage();
        int newQuantity = storage.getQuantity(fruitTransaction.getFruit())
                - fruitTransaction.getQuantity();
        if (newQuantity >= 0) {
            storage.set(fruitTransaction.getFruit(), newQuantity);
        } else {
            throw new RuntimeException("negative balance cannot be recorded");
        }
    }
}

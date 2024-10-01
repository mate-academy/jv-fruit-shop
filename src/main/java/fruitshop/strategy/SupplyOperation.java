package fruitshop.strategy;

import fruitshop.db.Storage;
import fruitshop.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handler(FruitTransaction fruitTransaction) {
        Storage storage = new Storage();
        int newQuantity = fruitTransaction.getQuantity()
                + storage.getQuantity(fruitTransaction.getFruit());
        if (newQuantity >= 0) {
            storage.set(fruitTransaction.getFruit(), newQuantity);
        } else {
            throw new RuntimeException("negative balance cannot be recorded");
        }
    }
}

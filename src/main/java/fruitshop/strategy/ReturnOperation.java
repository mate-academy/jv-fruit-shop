package fruitshop.strategy;

import fruitshop.db.Storage;
import fruitshop.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    private final Storage storage = new Storage();

    @Override
    public void handler(FruitTransaction fruitTransaction) {
        int newQuantity = fruitTransaction.getQuantity()
                + storage.getQuantity(fruitTransaction.getFruit());
        if (newQuantity >= 0) {
            storage.put(fruitTransaction.getFruit(), newQuantity);
        } else {
            throw new RuntimeException("negative balance cannot be recorded at "
                    + ReturnOperation.class);
        }
    }
}

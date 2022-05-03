package operation;

import db.Storage;
import model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void process(FruitTransaction fruitTransaction) {
        Integer initialQuality = Storage.data.get(fruitTransaction.getFruit());
        if (initialQuality - fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("Can't purchase the product");
        }
        Storage.data.put(fruitTransaction.getFruit(),
                initialQuality == null ? fruitTransaction.getQuantity()
                        : initialQuality - fruitTransaction.getQuantity());
    }
}

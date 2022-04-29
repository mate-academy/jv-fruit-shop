package strategy;

import db.Storage;
import model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void process(FruitTransaction fruitTransaction) {
        Integer initialQuality = Storage.map.get(fruitTransaction.getFruit());
        Storage.map.put(fruitTransaction.getFruit(),
                initialQuality == null ? fruitTransaction.getQuantity()
                        : fruitTransaction.getQuantity() + initialQuality);
    }
}

package fruitshop.strategy;

import fruitshop.db.Storage;
import fruitshop.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int newQuantity = Storage.get(transaction.getFruit()) + transaction.getQuantity();
        Storage.put(transaction.getFruit(), newQuantity);
    }
}

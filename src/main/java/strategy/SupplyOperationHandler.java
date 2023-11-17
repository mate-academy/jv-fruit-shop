package strategy;

import model.FruitTransaction;
import storage.Storage;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        Integer quantity = Storage.fruitQuantities.get(fruitTransaction.getFruit());
        Integer newQuantity = quantity + fruitTransaction.getQuantity();
        Storage.fruitQuantities.put(fruitTransaction.getFruit(), newQuantity);
    }
}

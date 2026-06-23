package strategy.handler;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int currentQuantity = Storage.fruitStorage.get(transaction.getFruit());
        int newQuantity = currentQuantity - transaction.getQuantity();
        if (newQuantity < 0) {
            throw new RuntimeException("Not enough fruit to sell. Fruit: " + transaction.getFruit()
                    + ", available: " + currentQuantity + ", requested: " + transaction.getQuantity());
        }
        Storage.fruitStorage.put(transaction.getFruit(), newQuantity);
    }
}

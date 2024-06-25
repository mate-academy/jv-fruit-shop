package strategy.handlers;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int currentQuantity = Storage.fruitStorage.getOrDefault(fruit, 0);
        int newQuantity = currentQuantity - transaction.getQuantity();
        if (newQuantity < 0) {
            throw new RuntimeException("Not enough " + fruit + " in stock to purchase.");
        }
        Storage.fruitStorage.put(fruit, newQuantity);
    }
}

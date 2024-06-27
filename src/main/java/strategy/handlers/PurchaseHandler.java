package strategy.handlers;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int purchaseQuantity = transaction.getQuantity();

        int currentQuantity = Storage.getFruitQuantity(fruit);
        int newQuantity = currentQuantity - purchaseQuantity;

        if (newQuantity < 0) {
            throw new RuntimeException("Not enough " + fruit + " in stock to purchase.");
        }

        Storage.addFruit(fruit, newQuantity);
    }
}

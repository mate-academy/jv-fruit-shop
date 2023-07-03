package strategy;

import db.ShopStorage;
import model.FruitTransaction;

public class SupplyStrategy implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction, ShopStorage storage) {
        int currentQuantity = storage.getQuantity(transaction.getFruit());
        int newQuantity = currentQuantity + transaction.getQuantity();
        storage.updateQuantity(transaction.getFruit(), newQuantity);
    }
}

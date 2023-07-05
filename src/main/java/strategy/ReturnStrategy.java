package strategy;

import db.ShopStorage;
import model.FruitTransaction;

public class ReturnStrategy implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, ShopStorage fruitStorage) {
        int currentQuantity = fruitStorage.getQuantity(transaction.getFruit());
        int newQuantity = currentQuantity + transaction.getQuantity();
        fruitStorage.updateQuantity(transaction.getFruit(), newQuantity);
    }
}

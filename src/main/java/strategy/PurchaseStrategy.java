package strategy;

import db.ShopStorage;
import model.FruitTransaction;

public class PurchaseStrategy implements OperationHandler {

    @Override
    public void handleOperation(FruitTransaction transaction, ShopStorage fruitStorage) {
        int currentQuantity = fruitStorage.getQuantity(transaction.getFruit());
        int newQuantity = currentQuantity - transaction.getQuantity();
        if (newQuantity < 0) {
            throw new RuntimeException("Insufficient quantity of "
                    + transaction.getFruit() + " for purchase");
        }
        fruitStorage.updateQuantity(transaction.getFruit(),newQuantity);
    }
}


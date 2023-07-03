package strategy;

import db.ShopStorage;
import model.FruitTransaction;

public class BalanceStrategy implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction, ShopStorage storage) {
        storage.updateQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}

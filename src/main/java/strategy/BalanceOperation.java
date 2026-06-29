package strategy;

import db.Storage;
import model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.updateQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}



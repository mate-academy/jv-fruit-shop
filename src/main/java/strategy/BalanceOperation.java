package strategy;

import db.Storage;
import model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Storage.setQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}

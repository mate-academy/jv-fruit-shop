package fruitshop.service;

import fruitshop.db.Storage;
import fruitshop.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
       Storage.setQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
package fruitshop.service;

import fruitshop.db.Storage;
import fruitshop.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
       Storage.incrementQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
package fruitshop.service;


import fruitshop.db.Storage;
import fruitshop.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        Storage.decrementQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
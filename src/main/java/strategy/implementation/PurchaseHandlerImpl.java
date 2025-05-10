package strategy.implementation;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class PurchaseHandlerImpl implements OperationHandler {

    @Override
    public void processTransaction(FruitTransaction transaction) {
        Integer oldQuantity = Storage.getStorage().get(transaction.getFruit());
        if (oldQuantity - transaction.getQuantity() < 0) {
            throw new RuntimeException("Not enough " + transaction.getFruit() + " in stock");
        }
        Storage.getStorage().put(transaction.getFruit(), oldQuantity - transaction.getQuantity());
    }
}
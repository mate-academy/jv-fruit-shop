package strategy.implementation;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class ReturnHandlerImpl implements OperationHandler {
    @Override
    public void processTransaction(FruitTransaction transaction) {
        Integer oldQuantity = Storage.getStorage().get(transaction.getFruit());
        Storage.getStorage().put(transaction.getFruit(), oldQuantity + transaction.getQuantity());
    }
}
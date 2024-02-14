package strategy;

import db.Storage;
import model.FruitTransaction;

public class PurchaseHandlerImpl implements OperationHandler {
    @Override
    public void processTransaction(FruitTransaction transaction) {
        Integer oldQuantity = Storage.getStorage().get(transaction.getFruit());
        Storage.getStorage().put(transaction.getFruit(), oldQuantity - transaction.getQuantity());
    }
}

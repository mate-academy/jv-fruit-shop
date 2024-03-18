package strategy;

import db.Storage;
import model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction transaction) {
        int oldQuantity = Storage.dataBase.get(transaction.getFruit());
        Storage.dataBase.put(transaction.getFruit(), oldQuantity - transaction.getQuantity());
    }
}

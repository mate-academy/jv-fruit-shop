package strategy;

import db.Storage;
import model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Integer fruitQuantity = Storage.storage.get(fruitTransaction.getFruit());
        if (fruitQuantity == null) {
            throw new RuntimeException("We didn`t sell such fruit: "
                    + fruitTransaction.getFruit().getName());
        }
        Storage.storage.replace(fruitTransaction.getFruit(),
                fruitQuantity + fruitTransaction.getQuantity());
        Storage.storage.get(fruitTransaction.getFruit());
    }
}

package strategy;

import db.Storage;
import model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void operationProcess(FruitTransaction fruitTransaction) {
        int quantity = Storage.fruitsStorage.get(fruitTransaction.getFruit());
        Storage.fruitsStorage.put(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity() + quantity);
    }
}

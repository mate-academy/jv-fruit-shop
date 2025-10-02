package strategy;

import db.Storage;
import model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Storage.getStorage().merge(transaction.getFruit(), transaction.getQuantity(), Integer::sum);
    }
}

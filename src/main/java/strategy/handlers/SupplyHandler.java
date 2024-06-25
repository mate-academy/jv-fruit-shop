package strategy.handlers;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class SupplyHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Storage.fruitStorage.merge(transaction.getFruit(), transaction.getQuantity(), Integer::sum);
    }
}

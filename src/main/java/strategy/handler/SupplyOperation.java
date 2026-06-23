package strategy.handler;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int currentQuantity = Storage.getQuantity(transaction.getFruit());
        Storage.setQuantity(transaction.getFruit(), currentQuantity + transaction.getQuantity());
    }
}

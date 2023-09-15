package fruitshop.strategy.handlers;

import fruitshop.db.Storage;
import fruitshop.model.FruitTransaction;
import fruitshop.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void calculateOperation(FruitTransaction transaction) {
        int balance = Storage.getStorage().get(transaction.getFruit());
        int calculationResult = balance + transaction.getQuantity();
        Storage.getStorage().put(transaction.getFruit(), calculationResult);
    }
}

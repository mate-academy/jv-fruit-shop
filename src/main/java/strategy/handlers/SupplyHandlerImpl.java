package strategy.handlers;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class SupplyHandlerImpl implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruitName();
        int storageFruitQuanity = Storage.fruitsStorage.get(fruitName);
        int transactionQuantity = fruitTransaction.getQuantity();
        Storage.fruitsStorage.replace(fruitName, storageFruitQuanity == null ? 0 : storageFruitQuantity 
                           + transactionQuantity);
    }
}

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
        if (!Storage.fruitsStorage.containsKey(fruitName)) {
            Storage.fruitsStorage.put(fruitName, transactionQuantity);
            return;
        }
        Storage.fruitsStorage.replace(fruitName, storageFruitQuanity + transactionQuantity);
    }
}

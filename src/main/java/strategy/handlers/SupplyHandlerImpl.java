package strategy.handlers;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class SupplyHandlerImpl implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruitName();
        Integer storageFruitQuantity = Storage.fruitsStorage.get(fruitName);
        Integer transactionQuantity = fruitTransaction.getQuantity();
        Storage.fruitsStorage.replace(fruitName,
                storageFruitQuantity == null ? 0 : storageFruitQuantity + transactionQuantity);
    }
}

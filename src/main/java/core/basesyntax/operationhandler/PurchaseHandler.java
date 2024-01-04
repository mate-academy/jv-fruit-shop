package core.basesyntax.operationhandler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {

    @Override
    public void handleOperation(FruitTransaction transaction, Storage storage) {

        Integer currentQuantity = Storage.fruits.get(transaction.getFruit());

        if (currentQuantity != null && currentQuantity >= transaction.getQuantity()) {
            Storage.fruits.put(transaction.getFruit(), currentQuantity - transaction.getQuantity());
        } else {
            System.out.println("Not enough quantity sold for " + transaction.getFruit());
        }
    }
}

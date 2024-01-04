package core.basesyntax.service.operationhandler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction, Storage storage) {
        Integer currentQuantity = Storage.fruits.get(transaction.getFruit());
        if (currentQuantity != null) {
            System.out.println(currentQuantity);
        } else {
            System.out.println("No such fruit in storage");
        }
    }
}

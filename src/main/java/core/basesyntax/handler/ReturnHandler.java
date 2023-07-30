package core.basesyntax.handler;

import core.basesyntax.database.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        int currentValue = Storage.fruits.get(transaction.getFruit());
        Storage.fruits.put(transaction.getFruit(), currentValue + transaction.getQuantity());
    }
}

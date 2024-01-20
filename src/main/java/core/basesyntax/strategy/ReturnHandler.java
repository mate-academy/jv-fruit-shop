package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.transaction.FruitTransaction;

public class ReturnHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int actualy = Storage.storage.get(transaction.getFruit());
        int past = actualy + transaction.getQuantity();
        Storage.storage.replace(transaction.getFruit(), past);
    }
}

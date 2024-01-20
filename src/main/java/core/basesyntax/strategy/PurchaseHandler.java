package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.transaction.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int past;
        int actualy = Storage.storage.get(transaction.getFruit());
        if (actualy > 0) {
            past = actualy - transaction.getQuantity();
        } else {
            throw new RuntimeException("This fruit is not in stock.");
        }
        if (past >= 0) {
            Storage.storage.replace(transaction.getFruit(), past);
        } else {
            throw new RuntimeException("There is only " + actualy + " of this fruit");
        }

    }
}

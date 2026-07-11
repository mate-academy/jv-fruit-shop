package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction transaction) {
        Integer currentAmount = Storage.getFruit(transaction.getFruit());
        int newCurrentAmount = currentAmount - transaction.getQuantity();
        if (newCurrentAmount < 0) {
            throw new RuntimeException("Not enough fruit in storage: "
                    + transaction.getFruit()
                    + ": balance " + currentAmount
                    + ", requested " + transaction.getQuantity());
        }
        Storage.putFruit(transaction.getFruit(), newCurrentAmount);
    }
}

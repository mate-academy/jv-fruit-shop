package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseAction implements Action {

    @Override
    public void action(FruitTransaction fruitTransaction) {
        int actualAmount = Storage.storage.get(fruitTransaction.getNameOfObject());
        if (actualAmount < fruitTransaction.getAmount()) {
            throw new RuntimeException("Not enough product "
                    + fruitTransaction.getNameOfObject()
                    + ", actual amount is "
                    + actualAmount
                    + ", while "
                    + fruitTransaction.getAmount()
                    + " requested");
        }
        Storage.storage.put(fruitTransaction.getNameOfObject(),
                actualAmount - fruitTransaction.getAmount());
    }
}

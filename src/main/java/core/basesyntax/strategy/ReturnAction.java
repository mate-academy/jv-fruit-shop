package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnAction implements Action {
    @Override
    public void action(FruitTransaction fruitTransaction) {
        Integer actualAmount = Storage.storage.get(fruitTransaction.getNameOfObject());
        if (actualAmount == null) {
            throw new RuntimeException("Seems you try to return non-existing product "
                    + fruitTransaction.getNameOfObject());
        }
        Storage.storage.put(fruitTransaction.getNameOfObject(),
                actualAmount + fruitTransaction.getAmount());
    }
}

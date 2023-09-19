package core.basesyntax.service.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void updateNumberOfFruit(FruitTransaction fruitTransaction) {
        int presentAmount = Storage.STORAGE.get(fruitTransaction.getFruit());
        int returnedAmount = fruitTransaction.getQuantity();
        int sumOfFruitAfterReturn = presentAmount + returnedAmount;
        Storage.STORAGE.put(fruitTransaction.getFruit(), sumOfFruitAfterReturn);
    }
}

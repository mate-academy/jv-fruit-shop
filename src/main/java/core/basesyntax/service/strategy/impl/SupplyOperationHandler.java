package core.basesyntax.service.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void updateNumberOfFruit(FruitTransaction fruitTransaction) {
        int presentAmount = Storage.STORAGE.get(fruitTransaction.getFruit());
        int suppliedAmount = fruitTransaction.getQuantity();
        int sumOfFruitAfterSupply = presentAmount + suppliedAmount;
        Storage.STORAGE.put(fruitTransaction.getFruit(), sumOfFruitAfterSupply);
    }
}

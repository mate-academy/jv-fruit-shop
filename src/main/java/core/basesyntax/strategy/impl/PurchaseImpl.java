package core.basesyntax.strategy.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseImpl implements OperationHandler {

    @Override
    public void operate(FruitTransaction transaction) {
        if (FruitStorage.fruits.containsKey(transaction.getFruit())) {
            FruitStorage.fruits.put(transaction.getFruit(),
                    FruitStorage.fruits.get(transaction.getFruit()) - transaction.getQuantity());
        } else {
            throw new RuntimeException("Impossible to get product from empty productStorage!");
        }
    }
}


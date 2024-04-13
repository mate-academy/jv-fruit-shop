package core.basesyntax.servise.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.servise.FruitTransaction;
import core.basesyntax.servise.strategy.OperationService;

public class IncomingOperationService implements OperationService {
    private final FruitTransaction fruitTransaction;

    public IncomingOperationService(FruitTransaction fruitTransaction) {
        this.fruitTransaction = fruitTransaction;
    }

    @Override
    public void calculation() {
        String fruit = fruitTransaction.getFruit();
        if (Storage.balance.containsKey(fruit)) {
            Storage.balance.put(fruit, Storage.balance.get(fruit)
                    + fruitTransaction.getQuantity());
            return;
        }
        Storage.balance.put(fruit, fruitTransaction.getQuantity());
    }
}

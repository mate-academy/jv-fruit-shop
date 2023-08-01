package core.basesyntax.strategy.handler.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.OperationHandler;

public class SupplyHandler implements OperationHandler {
    private final AddToStorage addToStorage;

    public SupplyHandler() {
        this.addToStorage = new AddToStorage();
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        addToStorage.add(fruitTransaction);

    }
}

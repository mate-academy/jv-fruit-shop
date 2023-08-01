package core.basesyntax.strategy.handler.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.OperationHandler;

public class ReturnHandler implements OperationHandler {
    private final AddToStorage addToStorage;

    public ReturnHandler() {
        this.addToStorage = new AddToStorage();
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        addToStorage.add(fruitTransaction);

    }
}

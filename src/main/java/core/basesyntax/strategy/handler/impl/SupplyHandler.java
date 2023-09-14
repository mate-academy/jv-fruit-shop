package core.basesyntax.strategy.handler.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.OperationHandler;

public class SupplyHandler implements OperationHandler {
    private final AdderToStorage adder;

    public SupplyHandler() {
        this.adder = new AdderToStorage();
    }

    @Override
    public void handle(FruitTransaction transaction) {
        adder.add(transaction);
    }
}

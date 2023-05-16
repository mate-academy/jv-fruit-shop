package core.basesyntax.strategy.handler.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.OperationHandler;

public class ReturnHandler implements OperationHandler {
    private final AdderToStorage adder;

    public ReturnHandler() {
        this.adder = new AdderToStorage();
    }

    @Override
    public void handle(FruitTransaction transaction) {
        adder.add(transaction);
    }
}

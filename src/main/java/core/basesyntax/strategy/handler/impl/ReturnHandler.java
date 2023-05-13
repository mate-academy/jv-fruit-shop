package core.basesyntax.strategy.handler.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.OperationHandler;

public class ReturnHandler implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction) {
        AdderToStorage.add(transaction);
    }
}

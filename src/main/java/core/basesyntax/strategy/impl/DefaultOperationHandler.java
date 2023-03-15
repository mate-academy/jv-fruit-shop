package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class DefaultOperationHandler implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        throw new RuntimeException("Wrong type of operation " + transaction.getOperation());
    }
}

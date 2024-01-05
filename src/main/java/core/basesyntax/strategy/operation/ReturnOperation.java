package core.basesyntax.strategy.operation;

import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public int handle(FruitTransaction fruit) {
        return +fruit.getAmount();
    }
}

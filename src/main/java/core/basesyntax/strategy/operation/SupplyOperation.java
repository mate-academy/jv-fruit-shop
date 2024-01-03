package core.basesyntax.strategy.operation;

import core.basesyntax.model.Store;

public class SupplyOperation implements Handler {
    @Override
    public int get(Store fruit) {
        return +fruit.getAmount();
    }
}

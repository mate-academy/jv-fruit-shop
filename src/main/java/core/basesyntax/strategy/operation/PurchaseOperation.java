package core.basesyntax.strategy.operation;

import core.basesyntax.model.Store;

public class PurchaseOperation implements Handler {
    @Override
    public int get(Store fruit) {
        return -fruit.getAmount();
    }
}

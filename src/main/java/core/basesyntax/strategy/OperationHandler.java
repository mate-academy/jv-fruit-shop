package core.basesyntax.strategy;

import core.basesyntax.model.Transaktion;

public interface OperationHandler {
    void apply(Transaktion transaktion);
}

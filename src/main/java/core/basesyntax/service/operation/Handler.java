package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;

public interface Handler {
    void apply(FruitTransaction transaction);
}

package core.basesyntax.service.strategy.handlers;

import core.basesyntax.model.FruitTransaction;

public interface ActivityHandler {
    void calculate(FruitTransaction value);
}

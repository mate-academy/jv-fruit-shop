package core.basesyntax.strategy.actions;

import core.basesyntax.model.FruitTransaction;

public interface ActionHandler {

    void apply(FruitTransaction transaction);
}

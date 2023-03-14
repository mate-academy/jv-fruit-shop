package core.basesyntax.strategy.actions;

import core.basesyntax.service.impl.FruitTransaction;
import core.basesyntax.storage.Storage;

public interface ActionHandler {

    void apply(Storage storage, String fruit, Integer quantity);

    boolean isApplicable(FruitTransaction.Operation action);
}

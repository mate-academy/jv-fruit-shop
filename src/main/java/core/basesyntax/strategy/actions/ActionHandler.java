package core.basesyntax.strategy.actions;

import core.basesyntax.storage.Storage;

public interface ActionHandler {

    void apply(Storage storage, String fruit, Integer quantity);

    String getCorrespondingAction();
}

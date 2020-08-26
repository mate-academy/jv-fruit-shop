package core.basesyntax.services;

import core.basesyntax.Storage;
import core.basesyntax.model.Fruit;

public interface ActionInterface {
    void action(Storage storage, Fruit fruit);
}

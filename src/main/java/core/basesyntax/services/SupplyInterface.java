package core.basesyntax.services;

import core.basesyntax.Storage;
import core.basesyntax.model.Fruit;

public interface SupplyInterface {
    void action(Storage storage, Fruit fruit);
}

package core.basesyntax.services;

import core.basesyntax.Storage;
import core.basesyntax.model.Fruit;

public interface BuyInterface {
    void action(Storage storage, Fruit fruit);
}

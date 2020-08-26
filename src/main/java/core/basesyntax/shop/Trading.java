package core.basesyntax.shop;

import core.basesyntax.Storage;
import core.basesyntax.model.Fruit;

public interface Trading {
    void trade(Storage storage, Fruit fruit);
}

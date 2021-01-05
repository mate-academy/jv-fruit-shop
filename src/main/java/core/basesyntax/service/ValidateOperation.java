package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public interface ValidateOperation {
    void validate(Storage storage, Fruit fruit, int amount);
}

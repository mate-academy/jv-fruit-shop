package core.basesyntax.service;

import core.basesyntax.model.Fruit;

public interface StorageUpdateService {
    Fruit update(Fruit fruit, Integer amount);
}

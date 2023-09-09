package core.basesyntax.service;

import core.basesyntax.model.FruitInStorage;
import java.util.Collection;

public interface WriterService {
    void write(Collection<FruitInStorage> fruits);
}

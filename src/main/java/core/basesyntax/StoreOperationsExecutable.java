package core.basesyntax;

import core.basesyntax.model.FruitDto;

public interface StoreOperationsExecutable {
    void executeOperation(Storage storage, FruitDto fruitDto);
}

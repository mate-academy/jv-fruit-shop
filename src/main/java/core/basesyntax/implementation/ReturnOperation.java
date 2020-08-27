package core.basesyntax.implementation;

import core.basesyntax.Storage;
import core.basesyntax.StoreOperationsExecutable;
import core.basesyntax.model.FruitDto;

public class ReturnOperation implements StoreOperationsExecutable {
    @Override
    public void executeOperation(Storage storage, FruitDto fruitDto) {
        storage.addItemData(fruitDto);
    }
}

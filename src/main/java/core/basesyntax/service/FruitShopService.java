package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operations.OperationHandler;

public interface FruitShopService {
    void addToStorage(FruitTransaction fruitTransaction, Storage storage,
                      OperationHandler operation);
}

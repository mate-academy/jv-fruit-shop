package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operations.OperationHandler;

public interface ShopService {
    OperationHandler transaction(FruitTransaction fruitTransactions);
}

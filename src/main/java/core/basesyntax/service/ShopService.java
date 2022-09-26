package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operations.OperationHandler;

import java.util.List;

public interface ShopService {

    OperationHandler transaction(FruitTransaction fruitTransactions);
}

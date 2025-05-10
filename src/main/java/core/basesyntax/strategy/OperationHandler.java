package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopDao;

public interface OperationHandler {
    void handleOperation(FruitTransaction transaction, FruitShopDao fruitShopDao);
}

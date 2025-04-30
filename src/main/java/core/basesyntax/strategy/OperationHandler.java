package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;

public interface OperationHandler {

    void handle(ShopService shopService, FruitTransaction fruitTransaction);
}

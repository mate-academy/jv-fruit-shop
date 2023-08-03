package core.basesyntax.service.interfaces;

import core.basesyntax.model.FruitShopOperation;
import core.basesyntax.service.transaction.TransactionHandler;

public interface TransactionStrategy {
    TransactionHandler get(FruitShopOperation fruitShopOperation);
}

package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitShopOperationsHandler;
import java.util.Map;

public interface ShopService {
    void process(FruitTransaction transaction, Map<FruitTransaction.Operation,
            FruitShopOperationsHandler> processSelector);
}

package core.basesyntax.strategy.handler;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.ShopServiceImpl;

public interface OperationHandler {
    ShopService SHOP_SERVICE = new ShopServiceImpl();

    void process(FruitTransaction fruit);
}

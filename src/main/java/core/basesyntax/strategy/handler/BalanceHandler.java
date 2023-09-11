package core.basesyntax.strategy.handler;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.ShopServiceImpl;

public class BalanceHandler implements OperationHandler {
    private final ShopService shopService = new ShopServiceImpl();

    @Override
    public void process(FruitTransaction fruit) {
        shopService.addFruits(fruit.getFruit(), fruit.getQuantity());
    }
}

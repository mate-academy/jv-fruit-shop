package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(ShopService shopService, FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        shopService.updateStorage(fruit, quantity);
    }
}

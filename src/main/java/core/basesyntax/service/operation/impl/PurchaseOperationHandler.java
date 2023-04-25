package core.basesyntax.service.operation.impl;

import core.basesyntax.service.fruitshop.FruitShopService;
import core.basesyntax.service.operation.OperationHandler;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PurchaseOperationHandler implements OperationHandler {
    private final FruitShopService fruitShopService;

    @Override
    public void operation(String fruit, int quantity) {
        fruitShopService.purchase(fruit, quantity);
    }
}

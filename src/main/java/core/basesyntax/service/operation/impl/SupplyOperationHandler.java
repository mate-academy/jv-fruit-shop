package core.basesyntax.service.operation.impl;

import core.basesyntax.service.fruitshop.FruitShopService;
import core.basesyntax.service.operation.OperationHandler;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SupplyOperationHandler implements OperationHandler {
    private final FruitShopService fruitShopService;

    @Override
    public void operation(String fruit, int quantity) {
        fruitShopService.supply(fruit, quantity);
    }
}

package core.basesyntax.service.operation.impl;

import core.basesyntax.service.fruitshop.FruitShopService;
import core.basesyntax.service.operation.OperationHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PurchaseOperationHandler implements OperationHandler {
    private final FruitShopService fruitShopService;

    @Override
    public int operation(String fruit, int quantity) {
        return fruitShopService.purchase(fruit, quantity);
    }
}

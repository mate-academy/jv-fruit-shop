package core.basesyntax.operation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;

public class BalanceOperation implements OperationHandler {
    private final FruitShopService fruitShopService;

    public BalanceOperation(FruitShopService fruitShopService) {
        this.fruitShopService = fruitShopService;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitShopService.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}

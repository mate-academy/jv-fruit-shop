package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    private final FruitShopService fruitShopService;

    public PurchaseOperation(FruitShopService fruitShopService) {
        this.fruitShopService = fruitShopService;
    }

    @Override
    public void processWithTransaction(FruitTransaction transaction) {
        fruitShopService.purchaseFruit(transaction);
    }
}

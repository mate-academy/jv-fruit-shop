package core.basesyntax.operation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;

public class PurchaseOperation implements OperationHandler {
    private final FruitShopService fruitShopService;

    public PurchaseOperation(FruitShopService fruitShopService) {
        this.fruitShopService = fruitShopService;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        if (fruitShopService.getStorage().containsKey(fruitTransaction.getFruit())
                && fruitShopService.getAmount(fruitTransaction.getFruit())
                >= fruitTransaction.getQuantity()) {
            fruitShopService.add(fruitTransaction.getFruit(),
                    fruitShopService.getAmount(fruitTransaction.getFruit())
                            - fruitTransaction.getQuantity());
            return;
        }
        throw new RuntimeException("Can`t sell this Fruit!");
    }
}

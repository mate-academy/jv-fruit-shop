package core.basesyntax.operation;

import core.basesyntax.dao.FruitShopService;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    private final FruitShopService fruitShopService;

    public PurchaseOperation(FruitShopService fruitShopDao) {
        this.fruitShopService = fruitShopDao;
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

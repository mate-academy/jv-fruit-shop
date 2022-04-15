package core.basesyntax.operation;

import core.basesyntax.dao.FruitShopService;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    private final FruitShopService fruitShopService;

    public SupplyOperation(FruitShopService fruitShopDao) {
        this.fruitShopService = fruitShopDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        if (fruitShopService.getStorage().containsKey(fruitTransaction.getFruit())) {
            fruitShopService.add(fruitTransaction.getFruit(),
                    fruitShopService.getAmount(fruitTransaction.getFruit())
                            + fruitTransaction.getQuantity());
        } else {
            fruitShopService.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
    }
}

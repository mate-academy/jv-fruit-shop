package core.basesyntax.operation;

import core.basesyntax.dao.FruitShopService;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    private final FruitShopService fruitShopService;

    public ReturnOperation(FruitShopService fruitShopDao) {
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

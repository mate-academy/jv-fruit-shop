package core.basesyntax.operation;

import core.basesyntax.dao.FruitShopService;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    private final FruitShopService fruitShopService;

    public BalanceOperation(FruitShopService fruitShopDao) {
        this.fruitShopService = fruitShopDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitShopService.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}

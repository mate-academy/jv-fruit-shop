package core.basesyntax.service.operations;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.impl.FruitShopDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class SupplyOprationHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction) {
        FruitShopDao fruitShopStorage = new FruitShopDaoImpl();
        fruitShopStorage.supply(fruitTransaction.getFruit().getFruitName(),
                fruitTransaction.getFruit().getQuantity());
    }
}

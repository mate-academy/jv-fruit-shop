package core.basesyntax.service.operations;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.impl.FruitShopDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction) {
        FruitShopDao fruitShopStorage = new FruitShopDaoImpl();
        fruitShopStorage.purchase(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}

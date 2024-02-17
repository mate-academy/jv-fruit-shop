package core.basesyntax.service.Operation;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.ShopServiceStrategy;

public class PurchaseHandler implements OperationHandler{
    @Override
    public void handle(String fruit, int amount) {
        StorageDaoImpl.removeProduct(ShopServiceStrategy.Operation.PURCHASE, amount);
    }
}

package core.basesyntax.service.Operation;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.ShopServiceStrategy;

public class ReturnHandler implements OperationHandler{
    @Override
    public void handle(String fruit, int amount) {
        StorageDaoImpl.addProduct(ShopServiceStrategy.Operation.SUPPLY, amount);
    }
}

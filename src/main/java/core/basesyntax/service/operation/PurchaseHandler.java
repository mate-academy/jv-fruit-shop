package core.basesyntax.service.operation;

import core.basesyntax.dao.StorageDaoImpl;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void handle(String fruit, int amount) {
        StorageDaoImpl.removeProduct(fruit, amount);
    }
}

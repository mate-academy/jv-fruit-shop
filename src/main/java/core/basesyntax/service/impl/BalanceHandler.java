package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class BalanceHandler implements OperationHandler {
    @Override
    public void toProcess(FruitTransaction fruitTransaction) {
        new StorageDaoImpl().create(
                fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}

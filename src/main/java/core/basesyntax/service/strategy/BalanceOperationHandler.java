package core.basesyntax.service.strategy;

import core.basesyntax.model.StorageDao;
import core.basesyntax.model.impl.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class BalanceOperationHandler implements OperationHandler<FruitTransaction> {

    @Override
    public void handle(FruitTransaction transaction) {
        StorageDao.add(transaction.getProductType(), transaction.getTransactionValue());
    }
}

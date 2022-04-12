package core.basesyntax.strategy.performers;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationPerformer;

public class BalanceOperationPerformer implements OperationPerformer {
    private StorageDao dao;

    public BalanceOperationPerformer(StorageDao dao) {
        this.dao = dao;
    }

    @Override
    public void perform(FruitTransaction transaction) {
        dao.set(transaction.getFruit(), transaction.getQuantity());
    }
}

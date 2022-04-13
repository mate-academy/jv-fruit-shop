package core.basesyntax.strategy.performers;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationPerformer;

public class ReturnOperationPerformer implements OperationPerformer {
    private StorageDao dao;

    public ReturnOperationPerformer(StorageDao dao) {
        this.dao = dao;
    }

    @Override
    public void perform(FruitTransaction transaction) {
        dao.add(transaction.getFruit(), transaction.getQuantity());
    }
}

package core.basesyntax.strategy.performers;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationPerformer;

public class SupplyOperationPerformer implements OperationPerformer {
    private StorageDao dao;

    public SupplyOperationPerformer(StorageDao dao) {
        this.dao = dao;
    }

    @Override
    public void perform(FruitTransaction transaction) {
        dao.add(transaction.getFruit(), transaction.getQuantity());
    }
}

package core.basesyntax.service.strategy;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    private FruitStorageDao storageDao;

    public SupplyOperation(FruitStorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        storageDao.getAllFruits()
                .merge(transaction.getFruit(), transaction.getQuantity(), Integer::sum);
    }
}

package core.basesyntax.service.impl;

import core.basesyntax.db.dao.StorageDao;
import core.basesyntax.db.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private final StorageDao storageDao;
    private final OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
        this.storageDao = new StorageDaoImpl();
    }

    @Override
    public void calculate(List<FruitTransaction> fruitTransaction) {
        for (FruitTransaction transaction:fruitTransaction) {
            calculate(transaction);
        }
    }

    private void calculate(FruitTransaction fruitTransaction) {
        Integer oldAmount = storageDao.get(fruitTransaction.getFruit());
        Integer newAmount = operationStrategy.get(fruitTransaction)
                .operate(fruitTransaction.getQuantity(), oldAmount);
        storageDao.set(fruitTransaction.getFruit(),newAmount);
    }
}

package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private final StorageDao storageDao;
    private final OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy optionalStrategy) {
        this.operationStrategy = optionalStrategy;
        this.storageDao = new StorageDaoImpl();
    }

    @Override
    public void processData(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction :fruitTransactions) {
            calculate(transaction);
        }
    }

    private void calculate(FruitTransaction fruitTransaction) {
        int oldCount = storageDao.getFruitQuantity(fruitTransaction.getFruit());
        int newCount = operationStrategy.get(fruitTransaction)
                .operate(fruitTransaction.getQuantity(), oldCount);
        storageDao.addFruit(fruitTransaction.getFruit(), newCount);
    }
}

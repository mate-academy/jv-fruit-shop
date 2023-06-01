package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handler.OperationHandler;
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
        for (FruitTransaction transaction : fruitTransactions) {
            OperationHandler handler = operationStrategy.get(transaction.getOperation());
            if (handler != null && isValidQuantity(transaction.getQuantity())) {
                int oldCount = storageDao.getFruitQuantity(transaction.getFruit());
                storageDao.addFruit(transaction.getFruit(),
                        handler.operate(transaction.getQuantity(), oldCount));
            }
        }
    }

    private boolean isValidQuantity(int quantity) {
        return quantity > 0;
    }
}

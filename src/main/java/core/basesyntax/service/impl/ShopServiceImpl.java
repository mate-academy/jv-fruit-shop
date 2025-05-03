package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.operation.OperationHandler;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;
    private StorageDao storageDao;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
        this.storageDao = new StorageDaoImpl();
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        transactions.stream().forEach(transaction -> {
            FruitTransaction.Operation operation = transaction
                    .getOperation();
            OperationHandler operationHandler = operationStrategy
                    .get(operation);
            int storedAmount = storageDao.get(transaction.getFruit());
            int resultAmount = operationHandler.makeOperation(transaction, storedAmount);
            storageDao.add(transaction.getFruit(), resultAmount);
        });
    }
}

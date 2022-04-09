package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationService;
import core.basesyntax.stratagy.OperationPerformerStrategy;
import core.basesyntax.stratagy.OperationPerformerStrategyImpl;
import java.util.List;

public class FruitShopServiceImpl implements OperationService {

    private OperationPerformerStrategy strategy = new OperationPerformerStrategyImpl();

    @Override
    public StorageDao processOperations(List<FruitTransaction> fruitTransactionList) {
        StorageDao storageDao = new StorageDaoImpl();
        for (FruitTransaction transaction : fruitTransactionList) {
            strategy.getOperationPerformer(transaction.getOperation())
                    .perform(storageDao, transaction);
        }
        return storageDao;
    }
}

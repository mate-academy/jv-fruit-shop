package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.StorageDao;
import core.basesyntax.stratagy.OperationPerformerStrategy;
import core.basesyntax.stratagy.OperationPerformerStrategyImpl;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {

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

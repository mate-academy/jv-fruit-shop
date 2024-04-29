package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitStorageService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitStorageServiceImpl implements FruitStorageService {
    private FruitStorageDao fruitStorageDao;
    private OperationStrategy operationStrategy;

    public FruitStorageServiceImpl(FruitStorageDao fruitStorageDao,
                                   OperationStrategy operationStrategy) {
        this.fruitStorageDao = fruitStorageDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction fruitTransaction : transactions) {
            operationStrategy.get(fruitTransaction.getOperation())
                    .updateFruitStorage(fruitTransaction, fruitStorageDao);
        }
        System.out.println("All transactions processed successfully");
    }
}

package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StoreService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class StoreServiceImpl implements StoreService {
    private FruitDao fruitDao;
    private OperationStrategy operationStrategy;

    public StoreServiceImpl(FruitDao fruitDao, OperationStrategy operationStrategy) {
        this.fruitDao = fruitDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public List<Fruit> processTransaction(List<FruitTransaction> dailyTransactions) {
        for (FruitTransaction dailyTransaction : dailyTransactions) {
            operationStrategy.get(dailyTransaction.getOperation()).apply(dailyTransaction);
        }
        return fruitDao.getAll();
    }
}

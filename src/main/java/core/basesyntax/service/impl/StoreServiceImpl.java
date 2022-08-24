package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
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
    public List<Fruit> fruitTransaction(List<FruitTransaction> dailyTransactions) {
        int amountFruits;

        for (FruitTransaction dailyTransaction : dailyTransactions) {
            amountFruits = operationStrategy.get(dailyTransaction.getOperation())
                    .getQuantity(dailyTransaction.getQuantity());
            fruitDao.get(dailyTransaction.getFruitName()).setQuantity(
                    fruitDao.get(dailyTransaction.getFruitName()).getQuantity() + amountFruits);
        }
        return fruitDao.getAll();
    }
}

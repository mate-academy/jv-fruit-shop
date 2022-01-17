package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.model.TransactionType;
import core.basesyntax.service.TransactionService;
import core.basesyntax.strategy.TransactionHandler;

import java.util.Map;

public class TransactionServiceImpl implements TransactionService {
    private final FruitDao fruitDao;
    private final Map<TransactionType, TransactionHandler> strategyMap;

    public TransactionServiceImpl(FruitDao fruitDao, Map<TransactionType, TransactionHandler> strategyMap) {
        this.fruitDao = fruitDao;
        this.strategyMap = strategyMap;
    }

    @Override
    public void accept(Transaction transaction) {
        Fruit fruit = fruitDao.get(transaction.getFruitName())
                .orElse(new Fruit(transaction.getFruitName()));
        TransactionHandler handler = strategyMap.get(transaction.getType());
        handler.perform(fruit, transaction);
        fruitDao.put(fruit);
    }
}

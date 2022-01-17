package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.FruitsConsumer;
import core.basesyntax.service.TransactionService;
import core.basesyntax.strategy.TransactionHandler;
import core.basesyntax.strategy.TransactionHandlerProvider;

public class TransactionServiceImpl implements TransactionService {
    private final FruitDao fruitDao;
    private final TransactionHandlerProvider provider = new TransactionHandlerProvider();

    public TransactionServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void accept(Transaction transaction) {
        Fruit fruit = fruitDao.get(transaction.getFruitName())
                .orElse(new Fruit(transaction.getFruitName()));
        TransactionHandler handler = provider.getHandler(transaction.getType());
        handler.perform(fruit, transaction);
        fruitDao.put(fruit);
    }
}

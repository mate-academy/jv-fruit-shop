package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.strategy.TransactionStrategy;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private FruitDao fruitDao;
    private TransactionStrategy strategy;

    public FruitTransactionServiceImpl(FruitDao fruitDao, TransactionStrategy strategy) {
        this.fruitDao = fruitDao;
        this.strategy = strategy;
    }

    @Override
    public void transaction(FruitTransaction fruitTransaction) {
        Fruit fruit = fruitDao.get(fruitTransaction.getFruit());

        int newQuantity = strategy.get(fruitTransaction.getOperation())
                .operation(fruit.getQuantity(), fruitTransaction.getQuantity());

        fruit.setQuantity(newQuantity);
        fruitDao.update(fruit);
    }
}

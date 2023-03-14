package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.TransactionDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private final TransactionDao transactionDao;
    private final TransactionStrategy transactionStrategy;
    private final FruitDao fruitDao;

    public FruitServiceImpl(TransactionDao transactionDao,
            FruitDao fruitDao,
            TransactionStrategy transactionStrategy) {
        this.transactionDao = transactionDao;
        this.fruitDao = fruitDao;
        this.transactionStrategy = transactionStrategy;
    }

    @Override
    public void add(FruitTransaction transaction) {
        transactionDao.add(transaction);
    }

    @Override
    public List<FruitTransaction> get(String fileName) {
        return transactionDao.get(fileName);
    }

    @Override
    public void update(List<FruitTransaction> transactions) {
        int fruitQuantity;
        for (FruitTransaction transaction : transactions) {
            fruitQuantity = transactionStrategy
                    .get(transaction.getOperation().getCode())
                    .doCalculation(transaction.getQuantity());
            String fruit = transaction.getFruit();
            fruitDao.updateStock(fruit, fruitQuantity);
        }
    }
}

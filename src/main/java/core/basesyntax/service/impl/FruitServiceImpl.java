package core.basesyntax.service.impl;

import core.basesyntax.dao.TransactionDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private final TransactionDao transactionDao;
    private TransactionStrategy transactionStrategy;

    public FruitServiceImpl(TransactionDao transactionDao, TransactionStrategy transactionStrategy) {
        this.transactionDao = transactionDao;
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
                    .get(transaction.getOperation())
                    .doCalculation(transaction.getQuantity());
            String fruit = transaction.getFruit();
            transactionDao.updateStock(fruit, fruitQuantity);
        }
    }
}

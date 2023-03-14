package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private final TransactionStrategy transactionStrategy;
    private final FruitDao fruitDao;
    private final ReaderService reader;

    public FruitServiceImpl(ReaderService reader,
            FruitDao fruitDao,
            TransactionStrategy transactionStrategy) {
        this.reader = reader;
        this.fruitDao = fruitDao;
        this.transactionStrategy = transactionStrategy;
    }

    @Override
    public List<FruitTransaction> get(String fileName) {
        return reader.read(fileName);
    }

    @Override
    public void updateAll(List<FruitTransaction> transactions) {
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

package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private final TransactionStrategy transactionStrategy;
    private final FruitDao fruitDao;

    public FruitServiceImpl(FruitDao fruitDao,
            TransactionStrategy transactionStrategy) {
        this.fruitDao = fruitDao;
        this.transactionStrategy = transactionStrategy;
    }

    @Override
    public void updateAll(List<TransactionDto> transactions) {
        int fruitQuantity;
        for (TransactionDto transaction : transactions) {
            fruitQuantity = transactionStrategy
                    .get(transaction.getOperation())
                    .doCalculation(transaction.getQuantity());
            String fruit = transaction.getFruit();
            fruitDao.updateStock(fruit, fruitQuantity);
        }
    }
}

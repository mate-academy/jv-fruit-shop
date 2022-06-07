package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private FruitDao fruitDao;
    private OperationStrategy operationStrategy;

    public FruitTransactionServiceImpl(FruitDao fruitDao, OperationStrategy operationStrategy) {
        this.fruitDao = fruitDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void transaction(List<FruitTransaction> statistic) {
        for (int i = 0; i < statistic.size(); i++) {
            FruitTransaction fruit = statistic.get(i);
            operationStrategy.get(fruit.getOperation()).get(fruit);
        }
    }
}

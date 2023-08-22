package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private final FruitDao fruitDao;
    private final OperationStrategy operationStrategy;

    public FruitTransactionServiceImpl(FruitDao fruitDao, OperationStrategy operationStrategy) {
        this.fruitDao = fruitDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void executeTransaction(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationHandler operationHandler =
                    operationStrategy.get(fruitTransaction.getOperation());
            Fruit fruit = new Fruit(fruitTransaction.getName(),
                    fruitTransaction.getQuantity());
            operationHandler.operate(fruit, fruitDao);
        }
    }
}

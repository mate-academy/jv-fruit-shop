package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private FruitDao fruitDao;
    private OperationStrategy operationStrategy;

    public ShopServiceImpl(FruitDao fruitDao, OperationStrategy operationStrategy) {
        this.fruitDao = fruitDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(transaction -> {
            OperationHandler operationHandler = operationStrategy.get(transaction.getOperation());
            operationHandler.calculate(fruitDao.get(transaction.getFruitName()), transaction);
        });
    }
}

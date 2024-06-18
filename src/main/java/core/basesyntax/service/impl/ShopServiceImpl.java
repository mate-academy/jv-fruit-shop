package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final FruitDao fruitDao;
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(FruitDao fruitDao, OperationStrategy operationStrategy) {
        this.fruitDao = fruitDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            Fruit fruit = fruitDao.getFruitByName(transaction.getFruit());
            OperationHandler handler = operationStrategy.get(transaction.getOperation());
            int balance = handler.executeOperation(fruit.getQuantity(), transaction.getQuantity());
            fruit.setQuantity(balance);
            fruitDao.update(fruit);
        }
    }
}

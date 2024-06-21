package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.operation.OperationHandler;
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
            processTransaction(transaction);
        }
    }

    private void processTransaction(FruitTransaction transaction) {
        Fruit fruit = getOrCreateFruit(transaction.getFruit());
        executeOperation(transaction, fruit);
    }

    private Fruit getOrCreateFruit(String fruitName) {
        if (!fruitDao.isPresent(fruitName)) {
            fruitDao.add(new Fruit(fruitName));
        }
        return fruitDao.getFruitByName(fruitName);
    }

    private void executeOperation(FruitTransaction transaction, Fruit fruit) {
        OperationHandler operationHandler = operationStrategy.get(transaction.getOperation());
        int balance = operationHandler.executeOperation(fruit.getQuantity(),
                transaction.getQuantity());
        fruit.setQuantity(balance);
        fruitDao.update(fruit);
    }
}

package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ShopService;
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
    public List<Fruit> getStatistic() {
        List<Fruit> fruits = fruitDao.getAll();
        fruits.forEach(fruit -> fruit.getFruitTransactions().forEach(transaction ->
                operationStrategy.get(transaction.getOperation()).calculate(fruit, transaction)));
        return fruits;
    }
}

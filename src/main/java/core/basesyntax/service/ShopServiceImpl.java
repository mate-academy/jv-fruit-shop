package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.db.Storage;
import core.basesyntax.domain.Fruit;

import java.util.List;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<Fruit> fruits) {
        int defaultValue = 0;
        for (Fruit fruit: fruits) {
            int quantity = operationStrategy.get(fruit.getOperation()).getQuantity(defaultValue, fruit.getQuantity());
            System.out.println(quantity);
        }
    }
}

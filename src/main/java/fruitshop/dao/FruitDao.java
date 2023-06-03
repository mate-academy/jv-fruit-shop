package fruitshop.dao;

import fruitshop.model.FruitTransaction;
import fruitshop.strategy.impl.OperationStrategy;

public interface FruitDao {
    void add(FruitTransaction transaction, OperationStrategy strategy);
}

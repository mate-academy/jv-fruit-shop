package fruitshop.dao;

import fruitshop.db.Storage;
import fruitshop.model.FruitTransaction;
import fruitshop.strategy.impl.OperationStrategy;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(FruitTransaction transaction, OperationStrategy strategy) {
        Storage.fruits.put(transaction, strategy);
    }
}

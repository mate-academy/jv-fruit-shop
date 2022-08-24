package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface StoreService {
    public List<Fruit> fruitTransaction(List<FruitTransaction> dailyTransactions);
}

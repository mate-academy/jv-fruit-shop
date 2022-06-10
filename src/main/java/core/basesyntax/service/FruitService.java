package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitService {
    List<Fruit> getAll(List<FruitTransaction> fruitTransactions);

    String getFruitsReport();
}

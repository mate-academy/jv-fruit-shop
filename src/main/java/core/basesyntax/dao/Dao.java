package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitsMovement;

import java.util.List;
import java.util.Map;

public interface Dao {
    List<Fruit> getAllFruits();
    List<FruitsMovement> getAllTransactions();
    List<FruitsMovement> getTransactionsOff(Fruit fruit);

    void saveResults(Map<Fruit, Integer> results);
}

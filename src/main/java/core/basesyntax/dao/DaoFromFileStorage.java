package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitsMovement;

import java.util.List;
import java.util.Map;

public class DaoFromFileStorage implements Dao{
    @Override
    public List<Fruit> getAllFruits() {
        return null;
    }

    @Override
    public List<FruitsMovement> getAllTransactions() {
        return null;
    }

    @Override
    public List<FruitsMovement> getTransactionsOff(Fruit fruit) {
        return null;
    }

    @Override
    public void saveResults(Map<Fruit, Integer> results) {

    }
}

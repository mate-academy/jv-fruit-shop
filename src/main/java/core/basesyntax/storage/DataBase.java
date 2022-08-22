package core.basesyntax.storage;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitMovement;

import java.util.List;
import java.util.Map;

public abstract class DataBase {
    protected List<FruitMovement> movementOfFruits;

    public abstract List<FruitMovement> getTransactionOf(Fruit fruit);
    public abstract List<Fruit> getAllFruits();
    public abstract void saveReport(Map<Fruit, Integer> results);
}

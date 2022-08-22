package core.basesyntax.storage;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitMovement;

import java.util.List;

public abstract class DataBase {
    protected List<FruitMovement> movementOfFruits;

    public abstract List<FruitMovement> getTransactionOf(Fruit fruit);
    public abstract List<Fruit> getAllFruits();
}

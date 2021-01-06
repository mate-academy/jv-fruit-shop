package core.basesyntax.fruitoperation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class OperationBalance implements Operation {
    @Override
    public void doOperation(Fruit fruit, int amount) {
        Map<Fruit, Integer> mapFruits = Storage.getFruits();
        if (mapFruits.containsKey(fruit)) {
            throw new RuntimeException("Incorrect operation!!! This fruit already has balance!");
        }
        mapFruits.put(fruit, amount);
    }
}

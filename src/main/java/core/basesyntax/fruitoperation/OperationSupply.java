package core.basesyntax.fruitoperation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class OperationSupply implements Operation {
    @Override
    public void doOperation(Storage storage, Fruit fruit, int amount) {
        Map<Fruit, Integer> mapFruits = storage.getFruits();
        if (!mapFruits.containsKey(fruit)) {
            throw new RuntimeException("Incorrect operation!!! This fruit not balanced!");
        }
        mapFruits.put(fruit, mapFruits.get(fruit) + amount);
    }
}

package core.basesyntax.fruitoperation;

import core.basesyntax.fruit.Fruits;

import java.util.Map;

public class OperationBalance implements Operation {
    @Override
    public void doOperation(Fruits fruits, String name, int amount) {
        Map<String, Integer> mapFruits = fruits.getFruits();
        if (mapFruits.containsKey(name)) {
            throw new RuntimeException("Incorrect operation!!! This fruit also balanced!");
        }
        mapFruits.put(name, amount);
    }
}

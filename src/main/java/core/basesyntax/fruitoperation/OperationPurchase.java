package core.basesyntax.fruitoperation;

import core.basesyntax.fruit.Fruits;

import java.util.Map;

public class OperationPurchase implements Operation {
    @Override
    public void doOperation(Fruits fruits, String name, int amount) {
        Map<String, Integer> mapFruits = fruits.getFruits();
        if (!mapFruits.containsKey(name)) {
            throw new RuntimeException("Incorrect operation!!! This fruit not balanced!");
        }
        if (mapFruits.get(name) - amount < 0) {
            throw  new RuntimeException("Sorry, byt we haven't enough fruits");
        }
        mapFruits.put(name, mapFruits.get(name) - amount);
    }
}

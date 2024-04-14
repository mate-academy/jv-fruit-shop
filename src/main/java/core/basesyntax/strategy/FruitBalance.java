package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitBalance implements FruitHandler {
    @Override
    public void transactionHandler(
            Map<String, Fruit> fruitsData,
            String fruitName,
            int fruitQuantity
    ) {
        Fruit fruit = fruitsData.get(fruitName);
        if (fruit == null) {
            Fruit newFruit = new Fruit(fruitName, fruitQuantity);
            fruitsData.put(fruitName, newFruit);
        } else {
            fruit.setQuantity(fruitQuantity);
        }
    }
}

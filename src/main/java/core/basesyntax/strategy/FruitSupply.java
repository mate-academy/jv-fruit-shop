package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitSupply implements FruitHandler {
    @Override
    public void transactionHandler(String[] transactionValues) {
        Map<String, Fruit> fruitsData = Storage.getFruits();
        String fruitName = transactionValues[FRUIT_NAME_INDEX];
        int fruitQuantity = Integer.parseInt(transactionValues[FRUIT_QUANTITY_INDEX]);
        Fruit fruit = fruitsData.get(fruitName);
        if (fruit == null) {
            Fruit newFruit = new Fruit(fruitName, fruitQuantity);
            fruitsData.put(fruitName, newFruit);
        } else {
            fruit.setQuantity(fruit.getQuantity() + fruitQuantity);
        }
    }
}

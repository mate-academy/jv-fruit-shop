package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitBalance implements FruitHandler {
    @Override
    public void transactionHandler(
            Map<String, Fruit> fruitsData,
            Fruit transactionFruit
    ) {
        String transactionFruitName = transactionFruit.getFruit();
        Fruit fruit = fruitsData.get(transactionFruitName);
        if (fruit == null) {
            fruitsData.put(transactionFruitName, transactionFruit);
        } else {
            fruit.setQuantity(transactionFruit.getQuantity());
        }
    }
}

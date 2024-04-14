package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitPurchase implements FruitHandler {
    @Override
    public void transactionHandler(
            Map<String, Fruit> fruitsData,
            String fruitName,
            int fruitQuantity
    ) {
        Fruit fruit = fruitsData.get(fruitName);
        if (fruit == null) {
            throw new RuntimeException("No fruits in storage to handle purchase");
        } else if (fruit.getQuantity() < fruitQuantity) {
            throw new RuntimeException(
                    "Impossible to handle purchase, because the of the lack of fruits"
            );
        }
        fruit.setQuantity(fruit.getQuantity() - fruitQuantity);
    }
}

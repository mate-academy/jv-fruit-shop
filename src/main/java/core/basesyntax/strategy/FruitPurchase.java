package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitPurchase implements FruitHandler {
    @Override
    public void transactionHandler(String[] transactionValues) {
        Map<String, Fruit> fruitsData = Storage.getFruits();
        String fruitName = transactionValues[FRUIT_NAME_INDEX];
        int fruitQuantity = Integer.parseInt(transactionValues[FRUIT_QUANTITY_INDEX]);
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

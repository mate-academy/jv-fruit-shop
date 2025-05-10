package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitPurchase implements FruitHandler {
    @Override
    public void transactionHandler(
            Map<String, Fruit> fruitsData,
            Fruit transactionFruit
    ) {
        Fruit fruit = fruitsData.get(transactionFruit.getFruit());
        int transactionFruitQuantity = transactionFruit.getQuantity();
        if (fruit == null) {
            throw new RuntimeException("No fruits in storage to handle purchase");
        } else if (fruit.getQuantity() < transactionFruitQuantity) {
            throw new RuntimeException(
                    "Impossible to handle purchase, because the of the lack of fruits"
            );
        }
        fruit.setQuantity(fruit.getQuantity() - transactionFruitQuantity);
    }
}

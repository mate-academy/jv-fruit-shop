package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;
import java.util.Map;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction,
                      Map<String, Integer> storage) {
        String fruit = transaction.getFruit();
        int availableQuantity = storage.getOrDefault(fruit, 0);

        if (availableQuantity < transaction.getQuantity()) {
            throw new RuntimeException("Not enough " + fruit + " in storage for purchase");
        }

        storage.merge(transaction.getFruit(), -transaction.getQuantity(), Integer::sum);
    }
}

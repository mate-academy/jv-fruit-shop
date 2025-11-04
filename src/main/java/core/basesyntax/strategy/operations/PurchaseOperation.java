package core.basesyntax.strategy.operations;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class PurchaseOperation implements OperationHandler {
    public void apply(FruitTransaction transaction, Map<String, Integer> processedData) {
        int currentQuantity = processedData.get(transaction.getFruit());
        if (transaction.getQuantity() > 0 && transaction.getQuantity() < currentQuantity) {
            if (processedData.containsKey(transaction.getFruit())) {
                processedData.replace(transaction.getFruit(),
                        (currentQuantity - transaction.getQuantity()));
            } else {
                throw new RuntimeException("Incorrect fruit. Fruit is not available");
            }
        } else {
            throw new RuntimeException(
                    "Incorrect input data for purchase."
                            + " Quantity should be greater than 0"
                            + " and less than or equal to current quantity");
        }
    }
}

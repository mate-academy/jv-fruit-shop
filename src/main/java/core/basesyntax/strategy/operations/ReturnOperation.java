package core.basesyntax.strategy.operations;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class ReturnOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction, Map<String, Integer> processedData) {
        if (transaction.getQuantity() > 0) {
            if (processedData.containsKey(transaction.getFruit())) {
                int currentQuantity = processedData.get(transaction.getFruit());
                processedData.replace(
                        transaction.getFruit(), (currentQuantity + transaction.getQuantity()));
            } else {
                processedData.put(transaction.getFruit(), transaction.getQuantity());
            }
        } else {
            throw new RuntimeException(
                    "Incorrect input data for return. Quantity should be greater than 0");
        }
    }
}

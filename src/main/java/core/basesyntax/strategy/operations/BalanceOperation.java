package core.basesyntax.strategy.operations;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class BalanceOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction, Map<String, Integer> processedData) {
        if (transaction.getQuantity() >= 0) {
            if (processedData.containsKey(transaction.getFruit())) {
                processedData.replace(transaction.getFruit(), transaction.getQuantity());
            } else {
                processedData.put(transaction.getFruit(), transaction.getQuantity());
            }
        } else {
            throw new RuntimeException(
                    "Incorrect input data for balance. Quantity should be greater or equal 0");
        }
    }
}

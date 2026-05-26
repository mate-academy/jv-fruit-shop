package core.basesyntax.strategy.handler;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class ReturnOperation implements OperationHandler {
    @Override
    public void execute(FruitTransaction transaction, Map<String, Integer> fruits) {
        if (transaction == null) {
            throw new RuntimeException("Illegal transaction");
        }
        int newValue = fruits.get(
                transaction.getName()) + transaction.getQuantity();
        fruits.put(transaction.getName(), newValue);
    }
}

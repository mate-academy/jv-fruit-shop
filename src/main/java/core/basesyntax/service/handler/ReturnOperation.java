package core.basesyntax.service.handler;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class ReturnOperation implements OperationHandler {
    @Override
    public void transaction(FruitTransaction fruitTransaction, Map<String, Integer> fruits) {
        fruits.replace(fruitTransaction.getFruitName(),
                (fruits.get(fruitTransaction.getFruitName())
                        + (fruitTransaction.getTransactionQuantity())));
    }
}

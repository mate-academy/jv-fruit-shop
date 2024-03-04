package core.basesyntax.service.quantity.handlers;

import core.basesyntax.entity.FruitTransaction;
import java.util.Map;
import java.util.Optional;

public class BalanceHandler implements OperationHandler {

    private static final String NEGATIVE_QUANTITY_ERROR_MESSAGE
            = "Quantity cannot be negative!";
    private static final String TRANSACTION_IS_NULL_ERROR_MESSAGE
            = "Transaction that was passed in the argument is null";

    @Override
    public void handleTransaction(FruitTransaction fruitTransaction,
                                  Map<String, Integer> fruitMap) {
        Optional.ofNullable(fruitTransaction)
                .orElseThrow(() -> new IllegalArgumentException(TRANSACTION_IS_NULL_ERROR_MESSAGE));
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        if (quantity < 0) {
            throw new RuntimeException(NEGATIVE_QUANTITY_ERROR_MESSAGE);
        }
        fruitMap.put(fruit, fruitMap.getOrDefault(fruit,0) + quantity);
    }
}

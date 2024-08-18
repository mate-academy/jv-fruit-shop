package core.basesyntax;

import java.util.Map;

public class ReturnOperation implements OperationHandler {
    private final Map<String, Integer> storage;

    public ReturnOperation(Map<String, Integer> storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        int quantity = transaction.getQuantity();
        if (quantity < 0) {
            throw new IllegalArgumentException("Invalid quantity: " + quantity);
        }
        storage.merge(transaction.getFruit(), quantity, Integer::sum);
    }
}

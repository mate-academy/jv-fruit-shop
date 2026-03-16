package core.basesyntax;

import java.util.Map;
import java.util.Objects;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> storage) {
        Objects.requireNonNull(transaction);
        Objects.requireNonNull(storage);
        storage.merge(transaction.getFruit(), -transaction.getQuantity(), Integer::sum);
    }
}

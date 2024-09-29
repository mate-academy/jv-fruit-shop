package core.basesyntax;

import java.util.Map;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(Map<String, Integer> storage, FruitTransaction transaction) {
        storage.merge(
                transaction.getFruit(),
                -transaction.getQuantity(),
                Integer::sum
        );
    }
}

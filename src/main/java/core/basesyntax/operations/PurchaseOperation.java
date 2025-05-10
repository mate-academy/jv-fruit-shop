package core.basesyntax.operations;

import core.basesyntax.FruitTransaction;
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

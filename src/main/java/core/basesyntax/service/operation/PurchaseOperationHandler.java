package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(Map<String, Integer> storage, FruitTransaction transaction) {
        storage.merge(
                transaction.getFruit(),
                -transaction.getQuantity(),
                Integer::sum
        );
    }
}

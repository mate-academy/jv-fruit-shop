package core.basesyntax.model.handler;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(Map<String, Integer> storage, FruitTransaction transaction) {
        storage.put(transaction.getFruit(),
                storage.get(transaction.getFruit()) - transaction.getQuantity());
    }
}

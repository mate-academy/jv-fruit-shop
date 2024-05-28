package core.basesyntax.service.operationhandlers;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> storage) {
        storage.merge(transaction.getFruit(),-transaction.getAmount(), Integer::sum);
    }
}

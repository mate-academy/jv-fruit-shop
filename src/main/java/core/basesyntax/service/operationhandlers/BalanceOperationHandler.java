package core.basesyntax.service.operationhandlers;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> storage) {
        storage.put(transaction.getFruit(),transaction.getAmount());
    }
}

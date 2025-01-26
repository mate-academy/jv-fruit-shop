package core.basesyntax.Operation;

import core.basesyntax.Model.FruitTransaction;

import java.util.Map;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(Map<String, Integer> storage, FruitTransaction transaction) {
        storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}

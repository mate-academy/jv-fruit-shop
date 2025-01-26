package core.basesyntax.Operation;

import core.basesyntax.Model.FruitTransaction;

import java.util.Map;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(Map<String, Integer> storage, FruitTransaction transaction) {
        storage.merge(transaction.getFruit(), transaction.getQuantity(), Integer::sum);
    }
}

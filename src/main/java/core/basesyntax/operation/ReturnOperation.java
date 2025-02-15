package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;

import java.util.Map;

public class ReturnOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction, Map<String, Integer> storage) {
        storage.merge(transaction.getFruit(), transaction.getQuantity(), Integer::sum);
    }
}

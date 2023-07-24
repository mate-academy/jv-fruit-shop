package core.basesyntax.strategy.handlers;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    private static final String EXCEPTION
            = "Each fruit should have balance operation as first operation type in input file";

    @Override
    public void handle(FruitTransaction transaction) {
        if (FruitStorage.FRUITS.isEmpty()) {
            throw new RuntimeException(EXCEPTION);
        }
        int quantity = FruitStorage.FRUITS.get(transaction.getFruit());
        FruitStorage.FRUITS.put(transaction.getFruit(), transaction.getQuantity() + quantity);
    }
}

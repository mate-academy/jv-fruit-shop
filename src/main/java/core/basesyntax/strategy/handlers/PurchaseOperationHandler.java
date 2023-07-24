package core.basesyntax.strategy.handlers;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private static final String EXCEPTION
            = "Each fruit should have balance operation as first operation type in input file";
    private static final String LESS_THAN_ZERO_EXCEPTION
            = "Quantity cannot be negative! Insert correct values to input file";

    @Override
    public void handle(FruitTransaction transaction) {
        if (FruitStorage.FRUITS.isEmpty()) {
            throw new RuntimeException(EXCEPTION);
        }
        int quantity = FruitStorage.FRUITS.get(transaction.getFruit());
        if ((quantity - transaction.getQuantity()) < 0) {
            throw new RuntimeException(LESS_THAN_ZERO_EXCEPTION);
        }
        FruitStorage.FRUITS.put(transaction.getFruit(), quantity - transaction.getQuantity());
    }
}

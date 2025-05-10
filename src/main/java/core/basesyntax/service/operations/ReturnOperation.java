package core.basesyntax.service.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.exceptions.InvalidFruitException;
import core.basesyntax.service.exceptions.InvalidOperationException;

public class ReturnOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        if (transaction.getOperation() != FruitTransaction.Operation.RETURN) {
            throw new InvalidOperationException("Invalid operation. Should be: 'RETURN', but was: "
                    + transaction.getOperation() + ".");
        }
        if (!Storage.containsKey(transaction.getFruit())) {
            throw new InvalidFruitException("Item: '" + transaction.getFruit()
            + "' doesn't exist in the storage");
        }
        int currentValue = Storage.getQuantity(transaction.getFruit());

        try {
            int newValue = Math.addExact(currentValue, transaction.getQuantity());
            Storage.put(transaction.getFruit(), newValue);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Integer overflow while updating quantity for fruit: "
                    + transaction.getFruit() + ".");
        }
    }
}

package core.basesyntax.service.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

/**
 * This class provides balance from transaction input file
 * @author Bartek
 */
public class BalanceOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        if (FruitTransaction.Operation.BALANCE.equals(transaction.getOperation())) {
            Storage.put(transaction.getFruit(), transaction.getQuantity());
        }
    }
}

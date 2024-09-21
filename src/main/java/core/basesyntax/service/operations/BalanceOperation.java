package core.basesyntax.service.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

//This class provides balance from transaction input file
public class BalanceOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        if (transaction.getOperation().equals(FruitTransaction.Operation.BALANCE)) {
            Storage.put(transaction.getFruit(), transaction.getQuantity());
        }
    }
}

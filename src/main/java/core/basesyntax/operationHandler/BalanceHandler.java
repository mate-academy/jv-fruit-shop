package core.basesyntax.operationHandler;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Operation;
import core.basesyntax.Storage;

public class  BalanceHandler  implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction, Storage storage) {
        storage.getBalance(transaction.getFruit());

    }

}

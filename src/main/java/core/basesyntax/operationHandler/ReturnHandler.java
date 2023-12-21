package core.basesyntax.operationHandler;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Operation;
import core.basesyntax.Storage;

public class ReturnHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction, Storage storage) {
        Storage.fruits.put(transaction.getFruit(), Storage.fruits.get(transaction.getFruit()) + transaction.getQuantity());


    }

  }

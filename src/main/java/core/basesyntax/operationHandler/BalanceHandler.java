package core.basesyntax.operationHandler;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Operation;
import core.basesyntax.Storage;

public class BalanceHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction, Storage storage) {
        // Output the entire balance on the storage
        System.out.println("Current balance:");

        for (String fruit : Storage.fruits.keySet()) {
            System.out.println(fruit + ": " + Storage.fruits.get(fruit));
        }
    }
}

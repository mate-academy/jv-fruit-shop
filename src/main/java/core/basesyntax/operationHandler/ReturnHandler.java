package core.basesyntax.operationHandler;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Operation;
import core.basesyntax.Storage;

public class ReturnHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction, Storage storage) {
        Integer currentQuantity = Storage.fruits.get(transaction.getFruit());

        if (currentQuantity != null && currentQuantity >= transaction.getQuantity()) {
            // Subtract the quantity that was previously sold
            Storage.fruits.put(transaction.getFruit(), currentQuantity - transaction.getQuantity());
        } else {
            // Handle the case where there was not enough quantity sold
            System.out.println("Not enough quantity sold for " + transaction.getFruit());
            // You might want to throw an exception or handle it according to your requirements
        }
    }
}

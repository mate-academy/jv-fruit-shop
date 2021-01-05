package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void changeReportInStorage(Transaction transaction) {
        Storage.fruitStorage.put(transaction.getFruit(),
                Storage.fruitStorage.containsKey(transaction.getFruit())
                        ? Storage.fruitStorage.get(transaction.getFruit())
                        + transaction.getQuantity()
                        : transaction.getQuantity()
        );
    }
}

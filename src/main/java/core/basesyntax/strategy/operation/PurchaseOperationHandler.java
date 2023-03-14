package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void accept(String data) {
        int indexOfSeparator = data.indexOf(OperationHandler.COMMA_SEPARATOR);
        int amount = Storage.STORAGE.get(data.substring(0, indexOfSeparator));
        Storage.STORAGE.put(data.substring(0, indexOfSeparator),
                amount - Integer.parseInt(data.substring(indexOfSeparator + 1)));
    }
}
